package org.example.dao_repositories;

import org.example.model.LessonVisiting;

import java.util.ArrayList;

public interface LessonVisitingDAO {

    LessonVisiting GetLessonVisiting(int lessonId);

    String AddLessonVisiting(int lessonId, ArrayList<String> students) throws Exception;

    String DeleteLessonVisiting(int lessonId) throws Exception;
}
