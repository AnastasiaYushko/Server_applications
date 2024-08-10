package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.student.add.AddStudentRequest;
import org.example.dto_request.student.delete.DeleteStudentRequest;
import org.example.dto_request.student.edit.EditStudentRequest;
import org.example.dto_request.student.get.byGroup.GetStudentsByGroupRequest;
import org.example.dto_request.student.get.byId.GetStudentByIdRequest;
import org.example.dto_response.student.AddStudentResponse;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.dto_response.student.GetStudentsByGroupResponse;

import javax.jcr.RepositoryException;

public interface StudentService {

    GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws JsonProcessingException, RepositoryException;

    GetStudentsByGroupResponse getStudentsByGroup(GetStudentsByGroupRequest request) throws JsonProcessingException, RepositoryException;

    String editStudent(EditStudentRequest request) throws Exception;

    AddStudentResponse addStudent(AddStudentRequest request) throws JsonProcessingException, RepositoryException;

    String deleteStudent(DeleteStudentRequest request) throws Exception;
}
