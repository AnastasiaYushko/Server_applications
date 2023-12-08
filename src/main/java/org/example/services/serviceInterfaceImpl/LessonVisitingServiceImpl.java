package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.DeleteLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.GetLessonVisitingRequest;
import org.example.dto_response.lessonVisiting.GetLessonVisitingResponse;
import org.example.services.serviceInterface.LessonVisitingService;

public class LessonVisitingServiceImpl implements LessonVisitingService{
    @Override
    public void addLessonVisiting(AddLessonVisitingRequest request) throws JsonProcessingException {

    }

    @Override
    public void deleteLessonVisiting(DeleteLessonVisitingRequest request) throws JsonProcessingException {

    }

    @Override
    public GetLessonVisitingResponse getLessonVisiting(GetLessonVisitingRequest request) throws JsonProcessingException {
        return null;
    }
}
