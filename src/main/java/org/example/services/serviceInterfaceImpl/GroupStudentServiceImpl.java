package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dao_repositories_implements.StudentGroupDAOImpl;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;
import org.example.model.StudentGroup;
import org.example.services.serviceInterface.GroupStudentsService;

import java.util.ArrayList;

public class GroupStudentServiceImpl implements GroupStudentsService {

    private final StudentGroupDAOImpl studentGroupDAO = new StudentGroupDAOImpl();

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException {
        StudentGroup group = studentGroupDAO.getStudentGroupById(request.getId());
        return new GetStudentGroupByIdResponse(group.getName());
    }

    @Override
    public GetStudentGroupsResponse getStudentGroups() {
        ArrayList<StudentGroup> listStudentGroup = studentGroupDAO.getStudentGroups();
        ArrayList<String> newListStudentGroup = new ArrayList<>();

        for (StudentGroup group : listStudentGroup) {
            newListStudentGroup.add(group.toString());
        }
        return new GetStudentGroupsResponse(newListStudentGroup);
    }

    @Override
    public String editStudentGroup(EditStudentGroupRequest request) {
        return studentGroupDAO.editStudentGroup(request.getId(), request.getName());
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) {
        int result = studentGroupDAO.addStudentGroup(request.getName());
        return new AddStudentGroupResponse(result);
    }

    @Override
    public String deleteStudentGroup(DeleteStudentGroupRequest request) {
        return studentGroupDAO.deleteStudentGroup(request.getId());
    }
}
