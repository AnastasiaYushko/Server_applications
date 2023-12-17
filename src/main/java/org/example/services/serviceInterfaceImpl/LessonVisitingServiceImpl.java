package org.example.services.serviceInterfaceImpl;

import org.example.dao_repositories_implements.LessonVisitingDAOImpl;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.DeleteLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.GetLessonVisitingRequest;
import org.example.dto_response.lessonVisiting.GetLessonVisitingResponse;
import org.example.services.serviceInterface.LessonVisitingService;

public class LessonVisitingServiceImpl implements LessonVisitingService{

    private final LessonVisitingDAOImpl lessonVisitingDAO = new LessonVisitingDAOImpl();
    @Override
    public String addLessonVisiting(AddLessonVisitingRequest request)  {
        return lessonVisitingDAO.AddLessonVisiting(request.getLessonId(),request.getListStudent());
    }

    @Override
    public String deleteLessonVisiting(DeleteLessonVisitingRequest request) {
        return lessonVisitingDAO.DeleteLessonVisiting(request.getLessonId());
    }

    @Override
    public GetLessonVisitingResponse getLessonVisiting(GetLessonVisitingRequest request) {
        return new GetLessonVisitingResponse(lessonVisitingDAO.GetLessonVisiting(request.getLessonId()).toString());
    }
}
