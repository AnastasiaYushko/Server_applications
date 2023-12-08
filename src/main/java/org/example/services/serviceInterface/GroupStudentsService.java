package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.EditStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;

public interface GroupStudentsService {

    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException;

    EditStudentGroupResponse editStudentGroup(EditStudentGroupRequest request) throws JsonProcessingException;

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws JsonProcessingException;

    void deleteStudentGroup(DeleteStudentGroupRequest request) throws JsonProcessingException;
}
