package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.EditStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.services.serviceInterface.GroupStudentsService;

public class GroupStudentServiceImpl implements GroupStudentsService {

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public EditStudentGroupResponse editStudentGroup(EditStudentGroupRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public void deleteStudentGroup(DeleteStudentGroupRequest request) throws JsonProcessingException {}
}
