package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.dto_response.subject.AddSubjectResponse;
import org.example.dto_response.subject.GetSubjectByIdResponse;
import org.example.dto_response.subject.GetSubjectsResponse;

import javax.xml.rpc.ServiceException;

public interface SubjectService {

    AddSubjectResponse addSubject(AddSubjectRequest request) throws JsonProcessingException, ServiceException;

    String deleteSubject(DeleteSubjectRequest request) throws JsonProcessingException, ServiceException;

    String editSubject(EditSubjectRequest request) throws JsonProcessingException, ServiceException;

    GetSubjectByIdResponse getSubjectById(GetSubjectByIdRequest request) throws JsonProcessingException, ServiceException;

    GetSubjectsResponse getSubjects() throws JsonProcessingException;

}
