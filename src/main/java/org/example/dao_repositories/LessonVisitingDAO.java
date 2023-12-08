package org.example.dao_repositories;

import org.example.model.LessonVisiting;
import org.example.model.Student;

import java.util.ArrayList;

public interface LessonVisitingDAO {

    LessonVisiting GetLessonVisitingRequest(int lessonId);

    void AddLessonVisiting(int lessonId, ArrayList<Student> students);

    void DeleteLessonVisitingRequest(int lessonId);
}
