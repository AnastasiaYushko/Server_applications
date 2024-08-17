package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.daoRepositoriesImplements.TeacherDAOImpl;
import org.example.dtoRequest.teacher.AddTeacherRequest;
import org.example.dtoRequest.teacher.DeleteTeacherRequest;
import org.example.dtoRequest.teacher.EditTeacherRequest;
import org.example.dtoRequest.teacher.GetTeacherByIdRequest;
import org.example.dtoResponse.teacher.AddTeacherResponse;
import org.example.dtoResponse.teacher.GetTeacherByIdResponse;
import org.example.dtoResponse.teacher.GetTeachersResponse;
import org.example.model.Teacher;
import org.example.services.serviceInterface.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

import java.util.ArrayList;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDAOImpl teacherDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAOImpl teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public AddTeacherResponse addTeacher(AddTeacherRequest request) throws ServiceException {
        int result;
        try {
            result = teacherDAO.addTeacher(request.getFirstName(), request.getMiddleName(), request.getLastName());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }

        AddTeacherResponse addTeacherResponse = SpringConfig.getContext().getBean("addTeacherResponse", AddTeacherResponse.class);
        addTeacherResponse.setId(result);
        return addTeacherResponse;
    }

    @Override
    public String deleteTeacher(DeleteTeacherRequest request) throws ServiceException {
        try {
            return teacherDAO.deleteTeacher(request.getId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String editTeacher(EditTeacherRequest request) throws ServiceException {
        try {
            return teacherDAO.editTeacher(request.getId(), request.getFirstName(), request.getMiddleName(), request.getLastName());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public GetTeacherByIdResponse getTeacherById(GetTeacherByIdRequest request) throws ServiceException {
        Teacher teacher;
        try {
            teacher = teacherDAO.getTeacherById(request.getId());
        }
        catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
        GetTeacherByIdResponse getTeacherByIdResponse = SpringConfig.getContext().getBean("getTeacherByIdResponse",GetTeacherByIdResponse.class);
        getTeacherByIdResponse.setFirstName(teacher.getFirstName());
        getTeacherByIdResponse.setLastName(teacher.getLastName());
        getTeacherByIdResponse.setMiddleName(teacher.getMiddleName());

        return getTeacherByIdResponse;
    }

    @Override
    public GetTeachersResponse getTeachers() {
        ArrayList<Teacher> listTeachers = teacherDAO.getTeachers();
        ArrayList<String> newListTeachers = new ArrayList<>();

        for (Teacher teacher : listTeachers) {
            newListTeachers.add(teacher.toString());
        }

        GetTeachersResponse getTeachersResponse = SpringConfig.getContext().getBean("getTeachersResponse",GetTeachersResponse.class);
        getTeachersResponse.setListTeachers(newListTeachers);
        return getTeachersResponse;
    }
}
