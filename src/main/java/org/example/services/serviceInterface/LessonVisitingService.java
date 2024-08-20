package org.example.services.serviceInterface;

import org.example.dto.dtoRequest.lessonVisiting.AddLessonVisitingRequest;
import org.example.dto.dtoRequest.lessonVisiting.DeleteLessonVisitingByIdRequest;
import org.example.dto.dtoRequest.lessonVisiting.DeleteLessonVisitingByLessonIdRequest;
import org.example.dto.dtoRequest.lessonVisiting.EditLessonVisitingRequest;
import org.example.dto.dtoRequest.lessonVisiting.GetLessonVisitingByLessonIdRequest;
import org.example.dto.dtoRequest.lessonVisiting.GetLessonVisitingByIdRequest;
import org.example.dto.dtoResponse.lessonVisiting.AddLessonVisitingResponse;
import org.example.dto.dtoResponse.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dto.dtoResponse.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

public interface LessonVisitingService {
    AddLessonVisitingResponse addLessonVisiting(AddLessonVisitingRequest request) throws RepositoryException, ServiceException, EntityNotFoundInDataBase, AddEntityMatchData;

    String deleteLessonVisitingById(DeleteLessonVisitingByIdRequest request) throws RepositoryException, ServiceException, EntityNotFoundInDataBase;

    String deleteLessonVisitingByLessonId(DeleteLessonVisitingByLessonIdRequest request) throws RepositoryException, ServiceException, EntityNotFoundInDataBase;

    GetLessonVisitingByIdResponse getLessonVisitingById(GetLessonVisitingByIdRequest request) throws RepositoryException, ServiceException, EntityNotFoundInDataBase;

    GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonId(GetLessonVisitingByLessonIdRequest request) throws RepositoryException, ServiceException, EntityNotFoundInDataBase;

    String editLessonVisiting(EditLessonVisitingRequest request) throws RepositoryException, ServiceException, StupidChanges, EntityNotFoundInDataBase;
}
