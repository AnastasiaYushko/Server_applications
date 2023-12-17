package org.example.services.serviceInterfaceImpl;

import org.example.dao_repositories_implements.SubjectDAOImpl;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.dto_response.subject.AddSubjectResponse;
import org.example.dto_response.subject.GetSubjectByIdResponse;
import org.example.dto_response.subject.GetSubjectsResponse;
import org.example.model.Subject;
import org.example.services.serviceInterface.SubjectService;

import java.util.ArrayList;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectDAOImpl subjectDAO = new SubjectDAOImpl();

    @Override
    public AddSubjectResponse addSubject(AddSubjectRequest request) {
        int result = subjectDAO.addSubject(request.getName());
        return new AddSubjectResponse(result);
    }

    @Override
    public String deleteSubject(DeleteSubjectRequest request) {
        return subjectDAO.deleteSubject(request.getId());
    }

    @Override
    public String editSubject(EditSubjectRequest request) {
        return subjectDAO.editSubject(request.getId(), request.getName());
    }

    @Override
    public GetSubjectByIdResponse getSubjectById(GetSubjectByIdRequest request) {
        Subject subject = subjectDAO.getSubjectById(request.getId());
        return new GetSubjectByIdResponse(subject.getName());
    }

    @Override
    public GetSubjectsResponse getSubjects() {
        ArrayList<Subject> listSubject = subjectDAO.getSubjects();
        ArrayList<String> newListSubject = new ArrayList<>();

        for (Subject subject : listSubject) {
            newListSubject.add(subject.toString());
        }

        return new GetSubjectsResponse(newListSubject);
    }
}
