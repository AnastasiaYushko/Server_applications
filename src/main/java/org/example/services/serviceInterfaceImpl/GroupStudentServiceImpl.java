package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.dao.daoRepositoriesImplements.StudentGroupDAOImpl;
import org.example.dto.dtoRequest.studentGroup.AddStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.DeleteStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.EditStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.GetStudentGroupByIdRequest;
import org.example.dto.dtoResponse.studentGroup.AddStudentGroupResponse;
import org.example.dto.dtoResponse.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto.dtoResponse.studentGroup.GetStudentGroupsResponse;
import org.example.model.StudentGroup;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterface.GroupStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupStudentServiceImpl implements GroupStudentsService {

    private final StudentGroupDAOImpl studentGroupDAO;

    @Autowired
    public GroupStudentServiceImpl(StudentGroupDAOImpl studentGroupDAO) {
        this.studentGroupDAO = studentGroupDAO;
    }

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws EntityNotFoundInDataBase {
        StudentGroup group;

        group = studentGroupDAO.getStudentGroupById(request.getId());

        GetStudentGroupByIdResponse getStudentGroupByIdResponse = SpringConfig.getContext().getBean("getStudentGroupByIdResponse", GetStudentGroupByIdResponse.class);
        getStudentGroupByIdResponse.setName(group.getName());
        return getStudentGroupByIdResponse;
    }

    @Override
    public GetStudentGroupsResponse getStudentGroups() {
        ArrayList<StudentGroup> listStudentGroup = studentGroupDAO.getStudentGroups();

        ArrayList<String> newListStudentGroup = new ArrayList<>();

        for (StudentGroup group : listStudentGroup) {
            newListStudentGroup.add(group.toString());
        }

        GetStudentGroupsResponse getStudentGroupsResponse = SpringConfig.getContext().getBean("getStudentGroupsResponse", GetStudentGroupsResponse.class);
        getStudentGroupsResponse.setGroups(newListStudentGroup);
        return getStudentGroupsResponse;
    }

    @Override
    public String editStudentGroup(EditStudentGroupRequest request) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        return studentGroupDAO.editStudentGroup(request.getId(), request.getName());
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws AddEntityMatchData {
        int result = studentGroupDAO.addStudentGroup(request.getName());
        AddStudentGroupResponse AddStudentGroupResponse = SpringConfig.getContext().getBean("addStudentGroupResponse", AddStudentGroupResponse.class);
        AddStudentGroupResponse.setId(result);
        return AddStudentGroupResponse;
    }

    @Override
    public String deleteStudentGroup(DeleteStudentGroupRequest request) throws EntityNotFoundInDataBase {
        return studentGroupDAO.deleteStudentGroup(request.getId());
    }
}
