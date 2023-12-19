package org.example.services.serviceInterfaceImpl;

import org.example.dao_repositories_implements.LessonVisitingDAOImpl;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.byId.DeleteLessonVisitingByIdRequest;
import org.example.dto_request.lessonVisiting.delete.byLessonId.DeleteLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.edit.EditLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.byILessonId.GetLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.get.byId.GetLessonVisitingByIdRequest;
import org.example.dto_response.lessonVisiting.AddLessonVisitingResponse;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.services.serviceInterface.LessonVisitingService;

public class LessonVisitingServiceImpl implements LessonVisitingService {

    private final LessonVisitingDAOImpl lessonVisitingDAO = new LessonVisitingDAOImpl();

    @Override
    public AddLessonVisitingResponse addLessonVisiting(AddLessonVisitingRequest request) {
        return new AddLessonVisitingResponse(lessonVisitingDAO.AddLessonVisiting(request.getLessonId(), request.getListStudent()));
    }

    @Override
    public String deleteLessonVisitingById(DeleteLessonVisitingByIdRequest request) {
        return lessonVisitingDAO.DeleteLessonVisitingById(request.getLessonVisitingId());
    }

    @Override
    public GetLessonVisitingByIdResponse getLessonVisitingById(GetLessonVisitingByIdRequest request) {
        return new GetLessonVisitingByIdResponse(lessonVisitingDAO.GetLessonVisitingById(request.getLessonVisitingId()).toString());
    }

    @Override
    public GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonId(GetLessonVisitingByLessonIdRequest request){
        return new GetLessonVisitingByLessonIdResponse(lessonVisitingDAO.GetLessonVisitingByLessonId(request.getLessonId()).toString());
    }

    @Override
    public String deleteLessonVisitingByLessonId(DeleteLessonVisitingByLessonIdRequest request){
        return lessonVisitingDAO.DeleteLessonVisitingByLessonId(request.getLessonId());
    }

    @Override
    public String editLessonVisiting(EditLessonVisitingRequest request){
        return lessonVisitingDAO.EditLessonVisiting(request.getLessonVisitingId(), request.getLessonId(),request.getListStudent());
    }

}
