package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dtoRequest.studentGroup.AddStudentGroupRequest;
import org.example.dtoRequest.studentGroup.DeleteStudentGroupRequest;
import org.example.dtoRequest.studentGroup.EditStudentGroupRequest;
import org.example.dtoRequest.studentGroup.GetStudentGroupByIdRequest;
import org.example.dtoResponse.studentGroup.AddStudentGroupResponse;
import org.example.dtoResponse.studentGroup.GetStudentGroupByIdResponse;
import org.example.dtoResponse.studentGroup.GetStudentGroupsResponse;

import javax.xml.rpc.ServiceException;

public interface GroupStudentsService {

    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException, ServiceException;

    GetStudentGroupsResponse getStudentGroups() throws JsonProcessingException, ServiceException;

    String editStudentGroup(EditStudentGroupRequest request) throws JsonProcessingException, ServiceException;

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws JsonProcessingException, ServiceException;

    String deleteStudentGroup(DeleteStudentGroupRequest request) throws JsonProcessingException, ServiceException;
}
