package org.example.dao.daoRepositoriesImplements;

import org.example.DataBase;
import org.example.SpringConfig;
import org.example.dao.daoRepositories.LessonVisitingDAO;
import org.example.enums.StatusStudent;
import org.example.model.LessonVisiting;
import org.example.model.Student;
import org.example.model.StudentGroup;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jcr.RepositoryException;
import java.util.ArrayList;

@Repository
public class LessonVisitingDAOImpl implements LessonVisitingDAO {
    @Autowired
    private final DataBase dataBase;

    public LessonVisitingDAOImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public LessonVisiting GetLessonVisitingByLessonId(int lessonId) throws RepositoryException {
        try {
            return dataBase.getLessonVisitingByLessonId(lessonId);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public LessonVisiting GetLessonVisitingById(int lessonVisitingById) throws RepositoryException {
        try {
            return dataBase.getLessonVisitingById(lessonVisitingById);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public int AddLessonVisiting(int lessonId, ArrayList<String> students1) throws RepositoryException {
        LessonVisiting lessonVisiting = SpringConfig.getContext().getBean("lessonVisiting", LessonVisiting.class);
        lessonVisiting.setLessonId(lessonId);

        ArrayList<Student> students = new ArrayList<>();

        for (String input : students1) {
            Student student = parseInStudent(input);
            students.add(student);
        }
        lessonVisiting.setListStudent(students);

        try {
            return dataBase.addLessonVisiting(lessonVisiting);
        } catch (EntityNotFoundInDataBase | AddEntityMatchData e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String EditLessonVisiting(int lessonVisitingId, int lessonId, ArrayList<String> students1) throws RepositoryException {
        LessonVisiting lessonVisiting = SpringConfig.getContext().getBean("lessonVisiting", LessonVisiting.class);
        lessonVisiting.setId(lessonVisitingId);
        lessonVisiting.setLessonId(lessonId);

        ArrayList<Student> students = new ArrayList<>();

        for (String input : students1) {
            Student student = parseInStudent(input);
            students.add(student.getId(), student);
        }
        lessonVisiting.setListStudent(students);
        try {
            return dataBase.editLessonVisiting(lessonVisiting);
        } catch (EntityNotFoundInDataBase | StupidChanges e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String DeleteLessonVisitingById(int lessonVisitingId) throws RepositoryException {
        try {
            return dataBase.deleteLessonVisitingById(lessonVisitingId);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public String DeleteLessonVisitingByLessonId(int lessonId) throws RepositoryException {
        try {
            return dataBase.deleteLessonVisitingByLessonId(lessonId);
        } catch (EntityNotFoundInDataBase e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    private static Student parseInStudent(String input) {
        // Массивы для хранения результатов
        String[] studentData = new String[5];
        String[] groupData = new String[2];

        // Извлечение данных о студенте
        studentData[0] = extractValue(input, "id=", ",");
        studentData[1] = extractValue(input, "lastName='", "',");
        studentData[2] = extractValue(input, "firstName='", "',");
        studentData[3] = extractValue(input, "middleName='", "',");
        studentData[4] = extractValue(input, "status=", ",");

        // Извлечение данных о группе
        groupData[0] = extractValue(input, "group=GroupOfStudents{id=", ",");
        groupData[1] = extractValue(input, "name='", "'}");

        StudentGroup studentGroup = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        studentGroup.setId(Integer.parseInt(groupData[0]));
        studentGroup.setName(groupData[1]);

        Student student = SpringConfig.getContext().getBean("student", Student.class);
        student.setId(Integer.parseInt(studentData[0]));
        student.setFirstName(studentData[2]);
        student.setStatus(StatusStudent.valueOf(studentData[4]));
        student.setLastName(studentData[1]);
        student.setMiddleName(studentData[3]);
        student.setGroup(studentGroup);

        return student;
    }

    private static String extractValue(String input, String prefix, String suffix) {
        int startIndex = input.indexOf(prefix) + prefix.length();
        int endIndex = input.indexOf(suffix, startIndex);
        return input.substring(startIndex, endIndex).trim();
    }
}
