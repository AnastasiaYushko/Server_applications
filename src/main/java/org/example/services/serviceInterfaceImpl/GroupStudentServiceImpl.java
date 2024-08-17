package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
import org.example.dao_repositories_implements.StudentGroupDAOImpl;
import org.example.dto_request.studentGroup.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;
import org.example.model.StudentGroup;
import org.example.services.serviceInterface.GroupStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;
import java.util.ArrayList;

@Service
public class GroupStudentServiceImpl implements GroupStudentsService {

    private final StudentGroupDAOImpl studentGroupDAO;

    @Autowired
    public GroupStudentServiceImpl(StudentGroupDAOImpl studentGroupDAO) {
        this.studentGroupDAO = studentGroupDAO;
    }

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException, ServiceException {
        StudentGroup group;
        try {
            group = studentGroupDAO.getStudentGroupById(request.getId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
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
    public String editStudentGroup(EditStudentGroupRequest request) throws ServiceException {
        try {
            return studentGroupDAO.editStudentGroup(request.getId(), request.getName());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws ServiceException {
        int result;
        try {
            result = studentGroupDAO.addStudentGroup(request.getName());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
        AddStudentGroupResponse AddStudentGroupResponse = SpringConfig.getContext().getBean("addStudentGroupResponse", AddStudentGroupResponse.class);
        AddStudentGroupResponse.setId(result);
        return AddStudentGroupResponse;
    }

    @Override
    public String deleteStudentGroup(DeleteStudentGroupRequest request) throws ServiceException {
        try {
            return studentGroupDAO.deleteStudentGroup(request.getId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
