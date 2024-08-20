package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.dao.daoRepositoriesImplements.TeacherDAOImpl;
import org.example.dto.dtoRequest.teacher.AddTeacherRequest;
import org.example.dto.dtoRequest.teacher.DeleteTeacherRequest;
import org.example.dto.dtoRequest.teacher.EditTeacherRequest;
import org.example.dto.dtoRequest.teacher.GetTeacherByIdRequest;
import org.example.dto.dtoResponse.teacher.AddTeacherResponse;
import org.example.dto.dtoResponse.teacher.GetTeacherByIdResponse;
import org.example.dto.dtoResponse.teacher.GetTeachersResponse;
import org.example.model.Teacher;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDAOImpl teacherDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAOImpl teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public AddTeacherResponse addTeacher(AddTeacherRequest request) throws AddEntityMatchData {
        int id = teacherDAO.addTeacher(request.getFirstName(), request.getMiddleName(), request.getLastName());

        AddTeacherResponse addTeacherResponse = SpringConfig.getContext().getBean("addTeacherResponse", AddTeacherResponse.class);
        addTeacherResponse.setId(id);
        return addTeacherResponse;
    }

    @Override
    public String deleteTeacher(DeleteTeacherRequest request) throws EntityNotFoundInDataBase {
        return teacherDAO.deleteTeacher(request.getId());
    }

    @Override
    public String editTeacher(EditTeacherRequest request) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        return teacherDAO.editTeacher(request.getId(), request.getFirstName(), request.getMiddleName(), request.getLastName());
    }


    @Override
    public GetTeacherByIdResponse getTeacherById(GetTeacherByIdRequest request) throws EntityNotFoundInDataBase {
        Teacher teacher = teacherDAO.getTeacherById(request.getId());

        GetTeacherByIdResponse getTeacherByIdResponse = SpringConfig.getContext().getBean("getTeacherByIdResponse", GetTeacherByIdResponse.class);
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

        GetTeachersResponse getTeachersResponse = SpringConfig.getContext().getBean("getTeachersResponse", GetTeachersResponse.class);
        getTeachersResponse.setListTeachers(newListTeachers);
        return getTeachersResponse;
    }
}
