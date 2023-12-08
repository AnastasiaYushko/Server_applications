package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.dto_response.subject.AddSubjectResponse;
import org.example.dto_response.subject.EditSubjectResponse;
import org.example.dto_response.subject.GetSubjectByIdResponse;
import org.example.dto_response.subject.GetSubjectsResponse;
import org.example.services.serviceInterface.SubjectService;

public class SubjectServiceImpl implements SubjectService {
    @Override
    public AddSubjectResponse addSubject(AddSubjectRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public void deleteSubject(DeleteSubjectRequest request) throws JsonProcessingException {

    }

    @Override
    public EditSubjectResponse editSubject(EditSubjectRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public GetSubjectByIdResponse getSubjectById(GetSubjectByIdRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public GetSubjectsResponse getSubjects() throws JsonProcessingException {
        return null;
    }
}
