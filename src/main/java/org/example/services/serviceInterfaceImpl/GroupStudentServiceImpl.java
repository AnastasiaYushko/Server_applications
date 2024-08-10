package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;
import java.util.ArrayList;


@Service("group_student_service")
public class GroupStudentServiceImpl implements GroupStudentsService {

    private final StudentGroupDAOImpl studentGroupDAO;

    @Autowired
    public GroupStudentServiceImpl(StudentGroupDAOImpl studentGroupDAO) {
        this.studentGroupDAO = studentGroupDAO;
    }

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException, ServiceException {
        try {
            StudentGroup group = studentGroupDAO.getStudentGroupById(request.getId());
            GetStudentGroupByIdResponse getStudentGroupByIdResponse = SpringConfig.getContext().getBean("getStudentGroupByIdResponse", GetStudentGroupByIdResponse.class);
            getStudentGroupByIdResponse.setName(group.getName());
            return getStudentGroupByIdResponse;
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
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
    public String editStudentGroup(EditStudentGroupRequest request) throws RepositoryException {
        return studentGroupDAO.editStudentGroup(request.getId(), request.getName());
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) {
        int result = studentGroupDAO.addStudentGroup(request.getName());
        AddStudentGroupResponse AddStudentGroupResponse = SpringConfig.getContext().getBean("addStudentGroupResponse", AddStudentGroupResponse.class);
        AddStudentGroupResponse.setId(result);
        return AddStudentGroupResponse;
    }

    @Override
    public String deleteStudentGroup(DeleteStudentGroupRequest request) throws RepositoryException {
        return studentGroupDAO.deleteStudentGroup(request.getId());
    }
}
