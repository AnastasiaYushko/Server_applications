package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.studentGroup.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;

import javax.xml.rpc.ServiceException;

public interface GroupStudentsService {

    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException, ServiceException;

    GetStudentGroupsResponse getStudentGroups() throws JsonProcessingException, ServiceException;

    String editStudentGroup(EditStudentGroupRequest request) throws JsonProcessingException, ServiceException;

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws JsonProcessingException, ServiceException;

    String deleteStudentGroup(DeleteStudentGroupRequest request) throws JsonProcessingException, ServiceException;
}
