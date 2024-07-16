package org.example.dao_repositories;

import org.example.model.LessonVisiting;

import java.util.ArrayList;

public interface LessonVisitingDAO {

    LessonVisiting GetLessonVisitingByLessonId(int lessonId);

    LessonVisiting GetLessonVisitingById(int lessonVisitingId);

    int AddLessonVisiting(int lessonId, ArrayList<String> students);

    String DeleteLessonVisitingById(int lessonVisitingId);

    String DeleteLessonVisitingByLessonId(int lessonId);

    String EditLessonVisiting(int lessonVisitingId, int lessonId, ArrayList<String> students);
}
