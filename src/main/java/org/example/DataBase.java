package org.example;

import org.example.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.Objects.isNull;

/*
 -- ADD
 ---- Нельзя добавить, которые уже имеются (кроме посещаемости);
 -- GET
 ---- BY ID
 ------ Нельзя получить то, чего нет;
 ---- LIST ( студентов группы, учителей, предметов)
 ------ Можно получить пустой;
 -- EDIT
 ---- Нельзя изменить то, чего нет;
 ---- Нельзя внести изменения, которые не отличаются от имеющихся значений;
 ---- Нельзя внести такие изменения,которые будут совпадать в другими данными по другому ID(кроме посещаемости);
 -- DELETE
 ---- Нельзя удалить, то чего нет


-- ГЛУБОКОЕ УДАЛЕНИЕ
----
-- Посещаемость
-- Урок -> Посещаемость
-- Студент -> Уроки -> Посещаемости
-- Группа -> Студенты -> Уроки -> Посещаемости
-- Учитель -> Уроки -> Посещаемости
 */

// Отловить 500

@Component
public class DataBase {

    private final Map<Integer, Student> listStudents;
    private Integer keyStudent;
    private final Map<Integer, StudentGroup> listGroups;
    private Integer keyGroup;
    private final Map<Integer, Teacher> listTeachers;
    private Integer keyTeacher;
    private final Map<Integer, Subject> listSubjects;
    private Integer keySubject;
    private final Map<Integer, Lesson> listLesson;
    private Integer keyLesson;

    private final Map<Integer, LessonVisiting> listLessonVisiting_Id;
    private Integer keyLessonVisiting_Id;

    private final Map<Integer, LessonVisiting> listLessonVisiting_LessonId;


    public DataBase() {
        keyStudent = 1;
        keyGroup = 1;
        keyTeacher = 1;
        keySubject = 1;
        keyLesson = 1;
        keyLessonVisiting_Id = 1;

        listStudents = new HashMap<>();
        listGroups = new HashMap<>();
        listTeachers = new HashMap<>();
        listSubjects = new HashMap<>();
        listLesson = new HashMap<>();
        listLessonVisiting_Id = new HashMap<>();
        listLessonVisiting_LessonId = new HashMap<>();
    }

//    public static DataBase getDataBase() {
//        if (dataBase == null) {
//            dataBase = new DataBase();
//        }
//        return dataBase;
//    }
//
//    public void clear() {
//        dataBase.listTeachers.clear();
//        dataBase.listStudents.clear();
//        dataBase.listGroups.clear();
//        dataBase.listSubjects.clear();
//        dataBase.listLesson.clear();
//        dataBase.listLessonVisiting_LessonId.clear();
//        dataBase.listLessonVisiting_Id.clear();
//
//        keyStudent = 1;
//        keyGroup = 1;
//        keyTeacher = 1;
//        keySubject = 1;
//        keyLesson = 1;
//        keyLessonVisiting_Id = 1;
//
//        dataBase = null;
//    }

    //Student

    public synchronized int addStudent(Student student) {
        synchronized (listStudents) {
            for (Student s : listStudents.values()) {
                if (s.equals(student)) {
                    throw new NullPointerException("Такой студент уже есть в системе");
                }
            }
            student.setId(keyStudent);
            listStudents.put(keyStudent, student);
        }
        keyStudent++;
        return keyStudent - 1;
    }

    public ArrayList<Student> getStudentsByGroup(int id) {
        getStudentGroupById(id);
        ArrayList<Student> result = new ArrayList<>();
        synchronized (listStudents) {
            for (Student s : listStudents.values()) {
                if ((s.getGroup().getId()) == id) {
                    result.add(s);
                }
            }
        }
        return result;
    }

    public Student getStudentById(int id) {
        Student student = listStudents.get(id);
        if (isNull(student)) {
            throw new NullPointerException("Такого студента нет в базе данных");
        }
        return student;
    }

    public String editStudent(Student student) {
        synchronized (listStudents) {
            Student student1 = getStudentById(student.getId());
            if (student.equals(student1)) {
                throw new NullPointerException("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }
            for (Student s : listStudents.values()) {
                if (s.equals(student)) {
                    throw new NullPointerException("Новые данные, которые вы хотите внести совпадают с другим студентом");
                }
            }
            listStudents.put(student.getId(), student);
        }
        return "Данные студента изменены";
    }

    public synchronized String deleteStudent(int id) {
        getStudentById(id);
        listStudents.remove(id);
        return "Студент удален";
    }
    //

    //Lesson
    public Lesson getLessonById(int id) {
        Lesson lesson = listLesson.get(id);
        if (isNull(lesson)) {
            throw new NullPointerException("Такого урока нет в базе данных");
        }
        return lesson;
    }

    public ArrayList<Lesson> getLessonsByGroup(Date startDate, Date endDate, int groupId) {
        StudentGroup group = getStudentGroupById(groupId);
        if (isNull(group)) {
            throw new NullPointerException("Такой группы нет в базе данных");
        }

        ArrayList<Lesson> lessonsList = new ArrayList<>();

        synchronized (listLesson) {
            for (Lesson l : listLesson.values()) {
                if ((endDate.after(l.getDate()) || endDate.equals(l.getDate())) && (startDate.before(l.getDate()) || endDate.equals(l.getDate()) && (l.getGroup().equals(group)))) {
                    lessonsList.add(l);
                }
            }
        }

        return lessonsList;
    }

    public ArrayList<Lesson> getLessonsByTeacher(Date startDate, Date endDate, int teacherId) {
        Teacher teacher = getTeacherById(teacherId);
        if (isNull(teacher)) {
            throw new NullPointerException("Такого учителя нет в базе данных");
        }

        ArrayList<Lesson> lessonsList = new ArrayList<>();

        synchronized (listLesson) {
            for (Lesson l : listLesson.values()) {
                if ((endDate.after(l.getDate())) && (startDate.before(l.getDate())) && (l.getTeacher().equals(teacher))) {
                    lessonsList.add(l);
                }
            }
        }

        return lessonsList;
    }


    public String EditLesson(Lesson lesson) {
        synchronized (listLesson) {
            Lesson lesson1 = getLessonById(lesson.getId());
            if (lesson.equals(lesson1)) {
                throw new NullPointerException("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }

            for (Lesson l : listLesson.values()) {
                if (lesson.equals(l)) {
                    throw new NullPointerException("Новые данные, которые вы хотите внести совпадают с другим уроком");
                }
            }
            listLesson.put(lesson.getId(), lesson);
        }
        return "Данные урока изменены!";
    }

    public synchronized int AddLesson(Lesson lesson) {
        synchronized (listLesson) {
            for (Lesson l : listLesson.values()) {
                if (lesson.equals(l)) {
                    throw new NullPointerException("Такой урок уже есть в базе данных");
                }
            }
            lesson.setId(keyLesson);
            listLesson.put(keyLesson, lesson);
        }
        keyLesson++;
        return keyLesson - 1;
    }

    public synchronized String DeleteLessonsByGroup(int groupId) {
        synchronized (listLesson) {
            getStudentGroupById(groupId);
            for (Lesson l : listLesson.values()) {
                if (l.getGroup().getId() == groupId) {
                    listLesson.remove(l.getId());
                    if (!isNull(getLessonVisitingByLessonId(l.getId()))) {
                        deleteLessonVisitingByLessonId(l.getId());
                    }
                }
            }
        }
        return "Уроки у группы удалены!";
    }

    public synchronized String DeleteLessonById(int lessonId) {
        synchronized (listLesson) {
            getLessonById(lessonId);
            listLesson.remove(lessonId);
        }

        if (!isNull(getLessonVisitingByLessonId(lessonId))) {
            deleteLessonVisitingByLessonId(lessonId);
        }
        return "Урок удален";
    }

    public synchronized String DeleteLessonsByTeacher(int teacherId) {
        synchronized (listLesson) {
            getTeacherById(teacherId);
            for (Lesson l : listLesson.values()) {
                if (l.getTeacher().getId() == teacherId) {
                    listLesson.remove(l.getId());
                    if (!isNull(getLessonVisitingByLessonId(l.getId()))) {
                        deleteLessonVisitingByLessonId(l.getId());
                    }
                }
            }
        }
        return "Урок удален";
    }
    //

    //StudentGroup
    public ArrayList<StudentGroup> getStudentGroups() {
        return new ArrayList<>(listGroups.values());
    }

    public StudentGroup getStudentGroupById(int id) {
        StudentGroup group = listGroups.get(id);
        if (isNull(group)) {
            throw new NullPointerException("Такой группы нет в базе данных");
        }
        return group;
    }

    public synchronized int addStudentGroup(StudentGroup group) {
        synchronized (listGroups) {
            for (StudentGroup studentGroup : listGroups.values()) {
                if (studentGroup.equals(group)) {
                    throw new NullPointerException("Такая группа уже есть в базе данных");
                }
            }
            group.setId(keyGroup);
            listGroups.put(keyGroup, group);
            keyGroup++;
            return keyGroup - 1;
        }
    }


    public String editStudentGroup(StudentGroup group) {
        synchronized (listGroups) {
            StudentGroup group0 = getStudentGroupById(group.getId());
            if (group.equals(group0)) {
                throw new NullPointerException("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }
            for (StudentGroup studentGroup : listGroups.values()) {
                if (studentGroup.equals(group)) {
                    throw new NullPointerException("Новые данные, которые вы хотите внести совпадают с другой группой");
                }
            }
            listGroups.put(group.getId(), group);
            return "Группа изменена";
        }
    }

    public synchronized String deleteStudentGroup(int id) {
        getStudentGroupById(id);
        listGroups.remove(id);
        return "Группа удалена";
    }
    //

    //Teacher
    public Teacher getTeacherById(int id) {
        Teacher teacher = listTeachers.get(id);
        if (isNull(teacher)) {
            throw new NullPointerException("Такого преподавателя нет в базе данных");
        }
        return teacher;
    }

    public ArrayList<Teacher> getTeachers() {
        return new ArrayList<>(listTeachers.values());
    }


    public synchronized int addTeacher(Teacher teacher) {
        synchronized (listTeachers) {
            for (Teacher teacher0 : listTeachers.values()) {
                if (teacher0.equals(teacher)) {
                    throw new NullPointerException("Такой преподаватель уже есть в базе данных");
                }
            }
            teacher.setId(keyTeacher);
            listTeachers.put(keyTeacher, teacher);
        }
        keyTeacher++;
        return keyTeacher - 1;
    }


    public String editTeacher(Teacher teacher) {
        synchronized (listTeachers) {
            Teacher teacher0 = getTeacherById(teacher.getId());
            if (teacher0.equals(teacher)) {
                throw new NullPointerException("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }
            for (Teacher t : listTeachers.values()) {
                if (t.equals(teacher)) {
                    throw new NullPointerException("Новые данные, которые вы хотите внести, совпадают с другим преподавателем");
                }
            }
            listTeachers.put(teacher.getId(), teacher);
        }
        return "Преподаватель изменен";
    }

    public synchronized String deleteTeacher(int id) {
        getTeacherById(id);
        listTeachers.remove(id);
        return "Преподаватель удален";
    }
    //

    //Subject

    public ArrayList<Subject> getSubjects() {
        return new ArrayList<>(listSubjects.values());
    }

    public Subject getSubjectById(int subjectId) {
        Subject subject = listSubjects.get(subjectId);
        if (isNull(subject)) {
            throw new NullPointerException("Такого урока нет в базе данных");
        }
        return subject;
    }

    public synchronized int addSubject(Subject subject) {
        synchronized (listSubjects) {
            for (Subject s : listSubjects.values()) {
                if (Objects.equals(s.getName(), subject.getName())) {
                    throw new NullPointerException("Такой предмет уже есть в базе данных");
                }
            }
            subject.setId(keySubject);
            listSubjects.put(keySubject, subject);
        }
        keySubject++;
        return keySubject - 1;
    }


    public String editSubject(Subject subject) {
        synchronized (listSubjects) {
            Subject subject1 = getSubjectById(subject.getId());
            if (subject1.equals(subject)) {
                throw new NullPointerException("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }
            for (Subject s : listSubjects.values()) {
                if (s.equals(subject)) {
                    throw new NullPointerException("Новые данные, которые вы хотите внести совпадают с другим предметом");
                }
            }
            listSubjects.put(subject.getId(), subject);
        }
        return "Предмет изменен";
    }

    public synchronized String deleteSubject(int id) {
        getSubjectById(id);
        listSubjects.remove(id);
        return "Предмет удален";
    }

    //

    // LessonVisiting

    public synchronized int addLessonVisiting(LessonVisiting lessonVisiting) {
        getLessonById(lessonVisiting.getLessonId());
        try {
            getLessonVisitingByLessonId(lessonVisiting.getLessonId());
            throw new NullPointerException("Данные о посещаемости данного урока уже есть в базе данных");
        } catch (NullPointerException e) {
            lessonVisiting.setId(keyLessonVisiting_Id);
            synchronized (listLessonVisiting_Id) {
                listLessonVisiting_Id.put(keyLessonVisiting_Id, lessonVisiting);
            }
            synchronized (listLessonVisiting_LessonId) {
                listLessonVisiting_LessonId.put(lessonVisiting.getLessonId(), lessonVisiting);
            }
            keyLessonVisiting_Id++;
            return keyLessonVisiting_Id - 1;
        }
    }

    public LessonVisiting getLessonVisitingById(int lessonVisitingId) {
        LessonVisiting lessonVisiting = listLessonVisiting_Id.get(lessonVisitingId);
        if (isNull(lessonVisiting)) {
            throw new NullPointerException("Данных о посещаемость данного урока нет в системе");
        }
        return lessonVisiting;
    }

    public LessonVisiting getLessonVisitingByLessonId(int lessonId) {
        LessonVisiting lessonVisiting = listLessonVisiting_LessonId.get(lessonId);
        if (isNull(lessonVisiting)) {
            throw new NullPointerException("Данных о посещаемость данного урока нет в системе");
        }
        return lessonVisiting;
    }


    public synchronized String editLessonVisiting(LessonVisiting lessonVisiting) {
        LessonVisiting lv = getLessonVisitingById(lessonVisiting.getId());
        getLessonById(lessonVisiting.getLessonId());

        if (lessonVisiting.equals(lv)) {
            throw new NullPointerException("Данные о посещаемости совпадают с имеющимися");
        }

        listLessonVisiting_Id.put(lessonVisiting.getId(), lessonVisiting);
        listLessonVisiting_LessonId.put(lessonVisiting.getLessonId(), lessonVisiting);
        return "Посещаемость изменена";
    }

    public synchronized String deleteLessonVisitingById(int lessonVisitingId) {
        //
        synchronized (listLessonVisiting_LessonId) {
            LessonVisiting lessonVisiting = getLessonVisitingById(lessonVisitingId);
            int id = lessonVisiting.getLessonId();
            if (!isNull(getLessonVisitingByLessonId(id))) {
                listLessonVisiting_LessonId.remove(id);
            }
            listLessonVisiting_Id.remove(lessonVisitingId);
        }
        return "Посещаемость удалена";
    }

    public synchronized String deleteLessonVisitingByLessonId(int lessonId) {
        return deleteLessonVisitingById(listLessonVisiting_LessonId.get(lessonId).getId());
    }
}
