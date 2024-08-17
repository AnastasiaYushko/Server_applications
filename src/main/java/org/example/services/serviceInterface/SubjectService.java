package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dtoRequest.subject.AddSubjectRequest;
import org.example.dtoRequest.subject.DeleteSubjectRequest;
import org.example.dtoRequest.subject.EditSubjectRequest;
import org.example.dtoRequest.subject.GetSubjectByIdRequest;
import org.example.dtoResponse.subject.AddSubjectResponse;
import org.example.dtoResponse.subject.GetSubjectByIdResponse;
import org.example.dtoResponse.subject.GetSubjectsResponse;

import javax.xml.rpc.ServiceException;

public interface SubjectService {

    AddSubjectResponse addSubject(AddSubjectRequest request) throws JsonProcessingException, ServiceException;

    String deleteSubject(DeleteSubjectRequest request) throws JsonProcessingException, ServiceException;

    String editSubject(EditSubjectRequest request) throws JsonProcessingException, ServiceException;

    GetSubjectByIdResponse getSubjectById(GetSubjectByIdRequest request) throws JsonProcessingException, ServiceException;

    GetSubjectsResponse getSubjects() throws JsonProcessingException;

}
