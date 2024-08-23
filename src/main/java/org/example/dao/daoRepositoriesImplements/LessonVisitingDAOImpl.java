package org.example.dao.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao.daoRepositories.LessonVisitingDAO;
import org.example.model.LessonVisiting;
import org.example.model.Student;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ConflictingData;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LessonVisitingDAOImpl implements LessonVisitingDAO {
    @Autowired
    private final DataBase dataBase;

    public LessonVisitingDAOImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public LessonVisiting GetLessonVisitingByLessonId(int lessonId) throws EntityNotFoundInDataBase {
        return dataBase.getLessonVisitingByLessonId(lessonId);
    }

    @Override
    public LessonVisiting GetLessonVisitingById(int lessonVisitingById) throws EntityNotFoundInDataBase {
        return dataBase.getLessonVisitingById(lessonVisitingById);
    }

    @Override
    public int AddLessonVisiting(int lessonId, ArrayList<String> students1) throws EntityNotFoundInDataBase, AddEntityMatchData, ConflictingData {
        LessonVisiting lessonVisiting = SpringConfig.getContext().getBean("lessonVisiting", LessonVisiting.class);
        lessonVisiting.setLessonId(lessonId);

        ArrayList<Student> students = new ArrayList<>();

        for (String input : students1) {
            Student student = Student.parseInStudent(input);
            students.add(student);
        }
        lessonVisiting.setListStudent(students);

        return dataBase.addLessonVisiting(lessonVisiting);
    }

    @Override
    public String EditLessonVisiting(int lessonVisitingId, int lessonId, ArrayList<String> students1) throws StupidChanges, EntityNotFoundInDataBase, ConflictingData {
        LessonVisiting lessonVisiting = SpringConfig.getContext().getBean("lessonVisiting", LessonVisiting.class);
        lessonVisiting.setId(lessonVisitingId);
        lessonVisiting.setLessonId(lessonId);

        ArrayList<Student> students = new ArrayList<>();

        for (String input : students1) {
            Student student = Student.parseInStudent(input);
            students.add(student);
        }
        lessonVisiting.setListStudent(students);

        return dataBase.editLessonVisiting(lessonVisiting);
    }

    @Override
    public String DeleteLessonVisitingById(int lessonVisitingId) throws EntityNotFoundInDataBase {
        return dataBase.deleteLessonVisitingById(lessonVisitingId);
    }

    @Override
    public String DeleteLessonVisitingByLessonId(int lessonId) throws EntityNotFoundInDataBase {
        return dataBase.deleteLessonVisitingByLessonId(lessonId);
    }

}
