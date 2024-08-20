package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.dao.daoRepositoriesImplements.StudentDAOImpl;
import org.example.dto.dtoRequest.student.*;
import org.example.dto.dtoResponse.student.AddStudentResponse;
import org.example.dto.dtoResponse.student.GetStudentByIdResponse;
import org.example.dto.dtoResponse.student.GetStudentsByGroupResponse;
import org.example.model.Student;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAOImpl studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAOImpl studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws EntityNotFoundInDataBase {
        Student student= studentDAO.getStudentById(request.getStudentId());

        GetStudentByIdResponse getStudentByIdResponse = SpringConfig.getContext().getBean("getStudentByIdResponse", GetStudentByIdResponse.class);
        getStudentByIdResponse.setFirstName(student.getFirstName());
        getStudentByIdResponse.setGroup(student.getGroup().getName());
        getStudentByIdResponse.setLastName(student.getLastName());
        getStudentByIdResponse.setMiddleName(student.getMiddleName());
        getStudentByIdResponse.setStatus(student.getStatus().name());

        return getStudentByIdResponse;
    }

    @Override
    public GetStudentsByGroupResponse getStudentsByGroup(GetStudentsByGroupRequest request) throws EntityNotFoundInDataBase {

        ArrayList<Student> listStudents = studentDAO.getStudentsByGroup(request.getGroupId());

        ArrayList<String> newListStudents = new ArrayList<>();

        for (Student student : listStudents) {
            newListStudents.add(student.toString());
        }

        GetStudentsByGroupResponse getStudentsByGroupResponse = SpringConfig.getContext().getBean("getStudentsByGroupResponse", GetStudentsByGroupResponse.class);
        getStudentsByGroupResponse.setListStudents(newListStudents);
        return getStudentsByGroupResponse;
    }

    @Override
    public String editStudent(EditStudentRequest request) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        return studentDAO.editStudent(request.getId(), request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getGroupId(), request.getStatus());
    }

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) throws EntityNotFoundInDataBase, AddEntityMatchData {
        int result = studentDAO.addStudent(request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getGroupId(), request.getStatus());

        AddStudentResponse addStudentResponse = SpringConfig.getContext().getBean("addStudentResponse", AddStudentResponse.class);
        addStudentResponse.setId(result);
        return addStudentResponse;
    }

    @Override
    public String deleteStudent(DeleteStudentRequest request) throws EntityNotFoundInDataBase {
        return studentDAO.deleteStudent(request.getStudentId());
    }
}
