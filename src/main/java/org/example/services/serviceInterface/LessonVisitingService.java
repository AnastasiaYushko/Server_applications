package org.example.services.serviceInterface;

import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.byId.DeleteLessonVisitingByIdRequest;
import org.example.dto_request.lessonVisiting.delete.byLessonId.DeleteLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.edit.EditLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.byILessonId.GetLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.get.byId.GetLessonVisitingByIdRequest;
import org.example.dto_response.lessonVisiting.AddLessonVisitingResponse;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByLessonIdResponse;

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
