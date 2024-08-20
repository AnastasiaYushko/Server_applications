package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.dtoRequest.studentGroup.AddStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.DeleteStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.EditStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.GetStudentGroupByIdRequest;
import org.example.dto.dtoResponse.studentGroup.AddStudentGroupResponse;
import org.example.dto.dtoResponse.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto.dtoResponse.studentGroup.GetStudentGroupsResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.xml.rpc.ServiceException;

public interface GroupStudentsService {

    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException, ServiceException, EntityNotFoundInDataBase;

    GetStudentGroupsResponse getStudentGroups() throws JsonProcessingException, ServiceException;

    String editStudentGroup(EditStudentGroupRequest request) throws JsonProcessingException, ServiceException, StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase;

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws JsonProcessingException, ServiceException, AddEntityMatchData;

    String deleteStudentGroup(DeleteStudentGroupRequest request) throws JsonProcessingException, ServiceException, EntityNotFoundInDataBase;
}
