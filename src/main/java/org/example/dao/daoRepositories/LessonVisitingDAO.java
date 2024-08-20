package org.example.dao.daoRepositories;

import org.example.model.LessonVisiting;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface LessonVisitingDAO {

    LessonVisiting GetLessonVisitingByLessonId(int lessonId) throws RepositoryException, EntityNotFoundInDataBase;

    LessonVisiting GetLessonVisitingById(int lessonVisitingId) throws RepositoryException, EntityNotFoundInDataBase;

    int AddLessonVisiting(int lessonId, ArrayList<String> students) throws RepositoryException, EntityNotFoundInDataBase, AddEntityMatchData;

    String DeleteLessonVisitingById(int lessonVisitingId) throws RepositoryException, EntityNotFoundInDataBase;

    String DeleteLessonVisitingByLessonId(int lessonId) throws RepositoryException, EntityNotFoundInDataBase;

    String EditLessonVisiting(int lessonVisitingId, int lessonId, ArrayList<String> students) throws RepositoryException, StupidChanges, EntityNotFoundInDataBase;
}
