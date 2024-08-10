package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

public interface GroupStudentsService {

    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException, ServiceException;

    GetStudentGroupsResponse getStudentGroups() throws JsonProcessingException, ServiceException;

    String editStudentGroup(EditStudentGroupRequest request) throws JsonProcessingException, RepositoryException;

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws JsonProcessingException;

    String deleteStudentGroup(DeleteStudentGroupRequest request) throws JsonProcessingException, RepositoryException;
}
