package org.example.services.serviceInterface;

import org.example.dtoRequest.lessonVisiting.AddLessonVisitingRequest;
import org.example.dtoRequest.lessonVisiting.DeleteLessonVisitingByIdRequest;
import org.example.dtoRequest.lessonVisiting.DeleteLessonVisitingByLessonIdRequest;
import org.example.dtoRequest.lessonVisiting.EditLessonVisitingRequest;
import org.example.dtoRequest.lessonVisiting.GetLessonVisitingByLessonIdRequest;
import org.example.dtoRequest.lessonVisiting.GetLessonVisitingByIdRequest;
import org.example.dtoResponse.lessonVisiting.AddLessonVisitingResponse;
import org.example.dtoResponse.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dtoResponse.lessonVisiting.GetLessonVisitingByLessonIdResponse;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

public interface LessonVisitingService {
    AddLessonVisitingResponse addLessonVisiting(AddLessonVisitingRequest request) throws RepositoryException, ServiceException;

    String deleteLessonVisitingById(DeleteLessonVisitingByIdRequest request) throws RepositoryException, ServiceException;

    String deleteLessonVisitingByLessonId(DeleteLessonVisitingByLessonIdRequest request) throws RepositoryException, ServiceException;

    GetLessonVisitingByIdResponse getLessonVisitingById(GetLessonVisitingByIdRequest request) throws RepositoryException, ServiceException;

    GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonId(GetLessonVisitingByLessonIdRequest request) throws RepositoryException, ServiceException;

    String editLessonVisiting(EditLessonVisitingRequest request) throws RepositoryException, ServiceException;
}
