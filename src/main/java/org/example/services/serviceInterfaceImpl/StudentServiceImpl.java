package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.dao.daoRepositoriesImplements.StudentDAOImpl;
import org.example.dto.dtoRequest.student.AddStudentRequest;
import org.example.dto.dtoRequest.student.DeleteStudentRequest;
import org.example.dto.dtoRequest.student.EditStudentRequest;
import org.example.dto.dtoRequest.student.GetStudentsByGroupRequest;
import org.example.dto.dtoRequest.student.GetStudentByIdRequest;
import org.example.dto.dtoResponse.student.AddStudentResponse;
import org.example.dto.dtoResponse.student.GetStudentByIdResponse;
import org.example.dto.dtoResponse.student.GetStudentsByGroupResponse;
import org.example.model.Student;
import org.example.services.serviceInterface.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAOImpl studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAOImpl studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws ServiceException {
        Student student;
        try {
            student = studentDAO.getStudentById(request.getStudentId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }

        GetStudentByIdResponse getStudentByIdResponse = SpringConfig.getContext().getBean("getStudentByIdResponse", GetStudentByIdResponse.class);
        getStudentByIdResponse.setFirstName(student.getFirstName());
        getStudentByIdResponse.setGroup(student.getGroup().getName());
        getStudentByIdResponse.setLastName(student.getLastName());
        getStudentByIdResponse.setMiddleName(student.getMiddleName());
        getStudentByIdResponse.setStatus(student.getStatus().name());

        return getStudentByIdResponse;
    }

    @Override
    public GetStudentsByGroupResponse getStudentsByGroup(GetStudentsByGroupRequest request) throws ServiceException {

        ArrayList<Student> listStudents;

        try {
            listStudents = studentDAO.getStudentsByGroup(request.getGroupId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
        ArrayList<String> newListStudents = new ArrayList<>();

        for (Student student : listStudents) {
            newListStudents.add(student.toString());
        }

        GetStudentsByGroupResponse getStudentsByGroupResponse = SpringConfig.getContext().getBean("getStudentsByGroupResponse", GetStudentsByGroupResponse.class);
        getStudentsByGroupResponse.setListStudents(newListStudents);
        return getStudentsByGroupResponse;
    }

    @Override
    public String editStudent(EditStudentRequest request) throws ServiceException {
        try {
            return studentDAO.editStudent(request.getId(), request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getGroupId(), request.getStatus());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) throws ServiceException {
        int result;
        try {
            result = studentDAO.addStudent(request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getGroupId(), request.getStatus());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
        AddStudentResponse addStudentResponse = SpringConfig.getContext().getBean("addStudentResponse", AddStudentResponse.class);
        addStudentResponse.setId(result);
        return addStudentResponse;
    }

    @Override
    public String deleteStudent(DeleteStudentRequest request) throws ServiceException {
        try {
            return studentDAO.deleteStudent(request.getStudentId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
