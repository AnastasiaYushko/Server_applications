package org.example.dao_repositories;

import org.example.model.LessonVisiting;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

public interface LessonVisitingDAO {

    LessonVisiting GetLessonVisitingByLessonId(int lessonId) throws RepositoryException;

    LessonVisiting GetLessonVisitingById(int lessonVisitingId) throws RepositoryException;

    int AddLessonVisiting(int lessonId, ArrayList<String> students) throws RepositoryException;

    String DeleteLessonVisitingById(int lessonVisitingId) throws RepositoryException;

    String DeleteLessonVisitingByLessonId(int lessonId) throws RepositoryException;

    String EditLessonVisiting(int lessonVisitingId, int lessonId, ArrayList<String> students) throws RepositoryException;
}
