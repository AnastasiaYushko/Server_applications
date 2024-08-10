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

public interface LessonVisitingService {
    AddLessonVisitingResponse addLessonVisiting(AddLessonVisitingRequest request) throws RepositoryException;

    String deleteLessonVisitingById(DeleteLessonVisitingByIdRequest request) throws RepositoryException;

    String deleteLessonVisitingByLessonId(DeleteLessonVisitingByLessonIdRequest request) throws RepositoryException;

    GetLessonVisitingByIdResponse getLessonVisitingById(GetLessonVisitingByIdRequest request) throws RepositoryException;

    GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonId(GetLessonVisitingByLessonIdRequest request) throws RepositoryException;

    String editLessonVisiting(EditLessonVisitingRequest request) throws RepositoryException;
}
