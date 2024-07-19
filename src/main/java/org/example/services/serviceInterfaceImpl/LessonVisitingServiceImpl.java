package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lesson_visiting_service")
public class LessonVisitingServiceImpl implements LessonVisitingService {

    private final LessonVisitingDAOImpl lessonVisitingDAO;

    @Autowired
    public LessonVisitingServiceImpl(LessonVisitingDAOImpl lessonVisitingDAO) {
        this.lessonVisitingDAO = lessonVisitingDAO;
    }

    @Override
    public AddLessonVisitingResponse addLessonVisiting(AddLessonVisitingRequest request) {
        int result = lessonVisitingDAO.AddLessonVisiting(request.getLessonId(), request.getListStudent());
        AddLessonVisitingResponse addLessonVisitingResponse = SpringConfig.getContext().getBean("addLessonVisitingResponse",AddLessonVisitingResponse.class);
        addLessonVisitingResponse.setId(result);

        return addLessonVisitingResponse;
    }

    @Override
    public String deleteLessonVisitingById(DeleteLessonVisitingByIdRequest request) {
        return lessonVisitingDAO.DeleteLessonVisitingById(request.getLessonVisitingId());
    }

    @Override
    public GetLessonVisitingByIdResponse getLessonVisitingById(GetLessonVisitingByIdRequest request) {
        String result = lessonVisitingDAO.GetLessonVisitingById(request.getLessonVisitingId()).toString();

        GetLessonVisitingByIdResponse getLessonVisitingByIdResponse = SpringConfig.getContext().getBean("getLessonVisitingByIdResponse",GetLessonVisitingByIdResponse.class);
        getLessonVisitingByIdResponse.setLessonVisiting(result);
        return getLessonVisitingByIdResponse;
    }

    @Override
    public GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonId(GetLessonVisitingByLessonIdRequest request){
        String result = lessonVisitingDAO.GetLessonVisitingByLessonId(request.getLessonId()).toString();

        GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonIdResponse = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdResponse",GetLessonVisitingByLessonIdResponse.class);
        getLessonVisitingByLessonIdResponse.setLessonVisiting(result);

        return getLessonVisitingByLessonIdResponse;
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
