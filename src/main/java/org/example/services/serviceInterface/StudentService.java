package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dtoRequest.student.AddStudentRequest;
import org.example.dtoRequest.student.DeleteStudentRequest;
import org.example.dtoRequest.student.EditStudentRequest;
import org.example.dtoRequest.student.GetStudentsByGroupRequest;
import org.example.dtoRequest.student.GetStudentByIdRequest;
import org.example.dtoResponse.student.AddStudentResponse;
import org.example.dtoResponse.student.GetStudentByIdResponse;
import org.example.dtoResponse.student.GetStudentsByGroupResponse;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

public interface StudentService {

    GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    GetStudentsByGroupResponse getStudentsByGroup(GetStudentsByGroupRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    String editStudent(EditStudentRequest request) throws Exception;

    AddStudentResponse addStudent(AddStudentRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    String deleteStudent(DeleteStudentRequest request) throws Exception;
}
