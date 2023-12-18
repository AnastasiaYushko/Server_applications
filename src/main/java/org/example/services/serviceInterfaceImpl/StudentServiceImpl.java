package org.example.services.serviceInterfaceImpl;

import org.example.dao_repositories_implements.StudentDAOImpl;
import org.example.dto_request.student.add.AddStudentRequest;
import org.example.dto_request.student.delete.DeleteStudentRequest;
import org.example.dto_request.student.edit.EditStudentRequest;
import org.example.dto_request.student.get.byGroup.GetStudentsByGroupRequest;
import org.example.dto_request.student.get.byId.GetStudentByIdRequest;
import org.example.dto_response.student.AddStudentResponse;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.dto_response.student.GetStudentsByGroupResponse;
import org.example.model.Student;
import org.example.services.serviceInterface.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {

    private final StudentDAOImpl studentDAO = new StudentDAOImpl();

    @Override
    public GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) {
        try {
            Student student = studentDAO.getStudentById(request.getId());
            return new GetStudentByIdResponse(student.getLastName(), student.getFirstName(), student.getMiddleName(), student.getStatus().name(), student.getGroup().getName());
        }
        catch (Exception e){
            throw new NullPointerException();
        }
    }

    @Override
    public GetStudentsByGroupResponse getStudentsByGroup(GetStudentsByGroupRequest request) {

        ArrayList<Student> listStudents = studentDAO.getStudentsByGroup(request.getGroupId());
        ArrayList<String> newListStudents = new ArrayList<>();

        for (Student student : listStudents) {
            newListStudents.add(student.toString());
        }

        return new GetStudentsByGroupResponse(newListStudents);
    }

    @Override
    public String editStudent(EditStudentRequest request){
        return studentDAO.editStudent(request.getId(), request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getGroup(), request.getStatus());
    }

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) {
        int result = studentDAO.addStudent(request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getGroup(), request.getStatus());
        return new AddStudentResponse(result);
    }

    @Override
    public String deleteStudent(DeleteStudentRequest request) {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        return studentDAO.deleteStudent(request.getStudentId());
    }
}
