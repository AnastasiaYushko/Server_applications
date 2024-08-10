package org.example.services.serviceInterfaceImpl;

import org.example.dao_repositories_implements.TeacherDAOImpl;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_response.teacher.AddTeacherResponse;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.dto_response.teacher.GetTeachersResponse;
import org.example.model.Teacher;
import org.example.services.serviceInterface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Service("teacher_service")
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDAOImpl teacherDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAOImpl teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public AddTeacherResponse addTeacher(AddTeacherRequest request) throws RepositoryException {
        int result = teacherDAO.addTeacher(request.getFirstName(), request.getMiddleName(), request.getLastName());
        return new AddTeacherResponse(result);
    }

    @Override
    public String deleteTeacher(DeleteTeacherRequest request) throws RepositoryException {
        return teacherDAO.deleteTeacher(request.getId());
    }

    @Override
    public String editTeacher(EditTeacherRequest request) throws RepositoryException {
        return teacherDAO.editTeacher(request.getId(), request.getFirstName(), request.getMiddleName(), request.getLastName());
    }

    @Override
    public GetTeacherByIdResponse getTeacherById(GetTeacherByIdRequest request) throws RepositoryException {
        Teacher teacher = teacherDAO.getTeacherById(request.getId());
        return new GetTeacherByIdResponse(teacher.getFirstName(), teacher.getLastName(), teacher.getMiddleName());
    }

    @Override
    public GetTeachersResponse getTeachers() {
        ArrayList<Teacher> listTeachers = teacherDAO.getTeachers();
        ArrayList<String> newListTeachers = new ArrayList<>();

        for (Teacher teacher : listTeachers) {
            newListTeachers.add(teacher.toString());
        }

        return new GetTeachersResponse(newListTeachers);
    }
}
