package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.DeleteLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.GetLessonVisitingRequest;
import org.example.dto_response.lessonVisiting.GetLessonVisitingResponse;

public interface LessonVisitingService {
    String addLessonVisiting(AddLessonVisitingRequest request) throws Exception;

    String deleteLessonVisiting(DeleteLessonVisitingRequest request) throws Exception;

    GetLessonVisitingResponse getLessonVisiting(GetLessonVisitingRequest request) throws JsonProcessingException;
}
