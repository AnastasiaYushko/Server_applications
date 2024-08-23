package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.dao.daoRepositoriesImplements.LessonVisitingDAOImpl;
import org.example.dto.dtoRequest.lessonVisiting.*;
import org.example.dto.dtoResponse.lessonVisiting.AddLessonVisitingResponse;
import org.example.dto.dtoResponse.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dto.dtoResponse.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ConflictingData;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterface.LessonVisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonVisitingServiceImpl implements LessonVisitingService {

    private final LessonVisitingDAOImpl lessonVisitingDAO;

    @Autowired
    public LessonVisitingServiceImpl(LessonVisitingDAOImpl lessonVisitingDAO) {
        this.lessonVisitingDAO = lessonVisitingDAO;
    }

    @Override
    public AddLessonVisitingResponse addLessonVisiting(AddLessonVisitingRequest request) throws EntityNotFoundInDataBase, AddEntityMatchData, ConflictingData {
        int result = lessonVisitingDAO.AddLessonVisiting(request.getLessonId(), request.getListStudent());

        AddLessonVisitingResponse addLessonVisitingResponse = SpringConfig.getContext().getBean("addLessonVisitingResponse", AddLessonVisitingResponse.class);
        addLessonVisitingResponse.setId(result);

        return addLessonVisitingResponse;
    }

    @Override
    public String deleteLessonVisitingById(DeleteLessonVisitingByIdRequest request) throws EntityNotFoundInDataBase {
        return lessonVisitingDAO.DeleteLessonVisitingById(request.getLessonVisitingId());
    }

    @Override
    public GetLessonVisitingByIdResponse getLessonVisitingById(GetLessonVisitingByIdRequest request) throws EntityNotFoundInDataBase {
        String result = lessonVisitingDAO.GetLessonVisitingById(request.getLessonVisitingId()).toString();

        GetLessonVisitingByIdResponse getLessonVisitingByIdResponse = SpringConfig.getContext().getBean("getLessonVisitingByIdResponse", GetLessonVisitingByIdResponse.class);
        getLessonVisitingByIdResponse.setLessonVisiting(result);
        return getLessonVisitingByIdResponse;
    }

    @Override
    public GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonId(GetLessonVisitingByLessonIdRequest request) throws EntityNotFoundInDataBase {
        String result = lessonVisitingDAO.GetLessonVisitingByLessonId(request.getLessonId()).toString();

        GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonIdResponse = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdResponse", GetLessonVisitingByLessonIdResponse.class);
        getLessonVisitingByLessonIdResponse.setLessonVisiting(result);

        return getLessonVisitingByLessonIdResponse;
    }

    @Override
    public String deleteLessonVisitingByLessonId(DeleteLessonVisitingByLessonIdRequest request) throws EntityNotFoundInDataBase {
        return lessonVisitingDAO.DeleteLessonVisitingByLessonId(request.getLessonId());
    }

    @Override
    public String editLessonVisiting(EditLessonVisitingRequest request) throws StupidChanges, EntityNotFoundInDataBase, ConflictingData {
        return lessonVisitingDAO.EditLessonVisiting(request.getLessonVisitingId(), request.getLessonId(), request.getListStudent());
    }
}
