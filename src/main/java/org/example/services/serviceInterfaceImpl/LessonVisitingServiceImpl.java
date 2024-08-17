package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.daoRepositoriesImplements.LessonVisitingDAOImpl;
import org.example.dtoRequest.lessonVisiting.AddLessonVisitingRequest;
import org.example.dtoRequest.lessonVisiting.DeleteLessonVisitingByIdRequest;
import org.example.dtoRequest.lessonVisiting.DeleteLessonVisitingByLessonIdRequest;
import org.example.dtoRequest.lessonVisiting.EditLessonVisitingRequest;
import org.example.dtoRequest.lessonVisiting.GetLessonVisitingByLessonIdRequest;
import org.example.dtoRequest.lessonVisiting.GetLessonVisitingByIdRequest;
import org.example.dtoResponse.lessonVisiting.AddLessonVisitingResponse;
import org.example.dtoResponse.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dtoResponse.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.services.serviceInterface.LessonVisitingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

@Service
public class LessonVisitingServiceImpl implements LessonVisitingService {

    private final LessonVisitingDAOImpl lessonVisitingDAO;

    @Autowired
    public LessonVisitingServiceImpl(LessonVisitingDAOImpl lessonVisitingDAO) {
        this.lessonVisitingDAO = lessonVisitingDAO;
    }

    @Override
    public AddLessonVisitingResponse addLessonVisiting(AddLessonVisitingRequest request) throws ServiceException {
        int result;
        try {
            result = lessonVisitingDAO.AddLessonVisiting(request.getLessonId(), request.getListStudent());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
        AddLessonVisitingResponse addLessonVisitingResponse = SpringConfig.getContext().getBean("addLessonVisitingResponse", AddLessonVisitingResponse.class);
        addLessonVisitingResponse.setId(result);

        return addLessonVisitingResponse;
    }

    @Override
    public String deleteLessonVisitingById(DeleteLessonVisitingByIdRequest request) throws ServiceException {
        try {
            return lessonVisitingDAO.DeleteLessonVisitingById(request.getLessonVisitingId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public GetLessonVisitingByIdResponse getLessonVisitingById(GetLessonVisitingByIdRequest request) throws ServiceException {
        String result;
        try {
            result = lessonVisitingDAO.GetLessonVisitingById(request.getLessonVisitingId()).toString();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }

        GetLessonVisitingByIdResponse getLessonVisitingByIdResponse = SpringConfig.getContext().getBean("getLessonVisitingByIdResponse", GetLessonVisitingByIdResponse.class);
        getLessonVisitingByIdResponse.setLessonVisiting(result);
        return getLessonVisitingByIdResponse;
    }

    @Override
    public GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonId(GetLessonVisitingByLessonIdRequest request) throws ServiceException {
        String result;
        try {
            result = lessonVisitingDAO.GetLessonVisitingByLessonId(request.getLessonId()).toString();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }

        GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonIdResponse = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdResponse", GetLessonVisitingByLessonIdResponse.class);
        getLessonVisitingByLessonIdResponse.setLessonVisiting(result);

        return getLessonVisitingByLessonIdResponse;
    }

    @Override
    public String deleteLessonVisitingByLessonId(DeleteLessonVisitingByLessonIdRequest request) throws ServiceException {
        try {
            return lessonVisitingDAO.DeleteLessonVisitingByLessonId(request.getLessonId());
        }
        catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String editLessonVisiting(EditLessonVisitingRequest request) throws ServiceException {
        try {
            return lessonVisitingDAO.EditLessonVisiting(request.getLessonVisitingId(), request.getLessonId(), request.getListStudent());
        }
        catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
