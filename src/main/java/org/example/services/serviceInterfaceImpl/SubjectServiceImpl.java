package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.dao.daoRepositoriesImplements.SubjectDAOImpl;
import org.example.dto.dtoRequest.subject.AddSubjectRequest;
import org.example.dto.dtoRequest.subject.DeleteSubjectRequest;
import org.example.dto.dtoRequest.subject.EditSubjectRequest;
import org.example.dto.dtoRequest.subject.GetSubjectByIdRequest;
import org.example.dto.dtoResponse.subject.AddSubjectResponse;
import org.example.dto.dtoResponse.subject.GetSubjectByIdResponse;
import org.example.dto.dtoResponse.subject.GetSubjectsResponse;
import org.example.model.Subject;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterface.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDAOImpl subjectDAO;

    @Autowired
    public SubjectServiceImpl(SubjectDAOImpl subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    @Override
    public AddSubjectResponse addSubject(AddSubjectRequest request) throws AddEntityMatchData {
        int result = subjectDAO.addSubject(request.getName());
        AddSubjectResponse addSubjectResponse = SpringConfig.getContext().getBean("addSubjectResponse", AddSubjectResponse.class);
        addSubjectResponse.setId(result);
        return addSubjectResponse;
    }


    @Override
    public String deleteSubject(DeleteSubjectRequest request) throws EntityNotFoundInDataBase {
        return subjectDAO.deleteSubject(request.getId());
    }

    @Override
    public String editSubject(EditSubjectRequest request) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        return subjectDAO.editSubject(request.getId(), request.getName());
    }

    @Override
    public GetSubjectByIdResponse getSubjectById(GetSubjectByIdRequest request) throws EntityNotFoundInDataBase {
        Subject subject = subjectDAO.getSubjectById(request.getId());
        GetSubjectByIdResponse getSubjectByIdResponse = SpringConfig.getContext().getBean("getSubjectByIdResponse",GetSubjectByIdResponse.class);
        getSubjectByIdResponse.setName(subject.getName());
        return getSubjectByIdResponse;
    }

    @Override
    public GetSubjectsResponse getSubjects() {
        ArrayList<Subject> listSubject = subjectDAO.getSubjects();
        ArrayList<String> newListSubject = new ArrayList<>();

        for (Subject subject : listSubject) {
            newListSubject.add(subject.toString());
        }

        GetSubjectsResponse getSubjectsResponse = SpringConfig.getContext().getBean("getSubjectsResponse",GetSubjectsResponse.class);
        getSubjectsResponse.setListSubjects(newListSubject);
        return getSubjectsResponse;
    }
}