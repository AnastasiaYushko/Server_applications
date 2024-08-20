package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.dtoRequest.subject.AddSubjectRequest;
import org.example.dto.dtoRequest.subject.DeleteSubjectRequest;
import org.example.dto.dtoRequest.subject.EditSubjectRequest;
import org.example.dto.dtoRequest.subject.GetSubjectByIdRequest;
import org.example.dto.dtoResponse.subject.AddSubjectResponse;
import org.example.dto.dtoResponse.subject.GetSubjectByIdResponse;
import org.example.dto.dtoResponse.subject.GetSubjectsResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.xml.rpc.ServiceException;

public interface SubjectService {

    AddSubjectResponse addSubject(AddSubjectRequest request) throws JsonProcessingException, ServiceException, AddEntityMatchData;

    String deleteSubject(DeleteSubjectRequest request) throws JsonProcessingException, ServiceException, EntityNotFoundInDataBase;

    String editSubject(EditSubjectRequest request) throws JsonProcessingException, ServiceException, StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase;

    GetSubjectByIdResponse getSubjectById(GetSubjectByIdRequest request) throws JsonProcessingException, ServiceException, EntityNotFoundInDataBase;

    GetSubjectsResponse getSubjects() throws JsonProcessingException;

}
