package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.student.AddStudentRequest;
import org.example.dto_request.student.DeleteStudentRequest;
import org.example.dto_request.student.EditStudentRequest;
import org.example.dto_request.student.GetStudentsByGroupRequest;
import org.example.dto_request.student.GetStudentByIdRequest;
import org.example.dto_response.student.AddStudentResponse;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.dto_response.student.GetStudentsByGroupResponse;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

public interface StudentService {

    GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    GetStudentsByGroupResponse getStudentsByGroup(GetStudentsByGroupRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    String editStudent(EditStudentRequest request) throws Exception;

    AddStudentResponse addStudent(AddStudentRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    String deleteStudent(DeleteStudentRequest request) throws Exception;
}
