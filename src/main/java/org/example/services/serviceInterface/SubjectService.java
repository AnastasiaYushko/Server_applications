package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.dto_response.subject.AddSubjectResponse;
import org.example.dto_response.subject.EditSubjectResponse;
import org.example.dto_response.subject.GetSubjectByIdResponse;
import org.example.dto_response.subject.GetSubjectsResponse;

public interface SubjectService{

    AddSubjectResponse addSubject(AddSubjectRequest request) throws JsonProcessingException;
    String deleteSubject(DeleteSubjectRequest request) throws JsonProcessingException;
    EditSubjectResponse editSubject(EditSubjectRequest request) throws JsonProcessingException;
    GetSubjectByIdResponse getSubjectById(GetSubjectByIdRequest request) throws JsonProcessingException;
    GetSubjectsResponse getSubjects() throws JsonProcessingException;

}
