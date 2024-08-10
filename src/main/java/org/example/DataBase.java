package org.example;

import org.example.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.Objects.isNull;

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
            for (int i = 1; i < keyStudent; i++) {
                Student s = listStudents.get(i);
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
            for (int i = 1; i < keyStudent; i++) {
                Student s = listStudents.get(i);
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
            throw new NullPointerException("Такого студента нет в системе");
        }
        return student;
    }

    public String editStudent(Student student) {
        Student student1 = getStudentById(student.getId());
        if (student.equals(student1)) {
            throw new NullPointerException("Новые данные, которые вы хотите внести, совпадают с имеющимися");
        }
        synchronized (listStudents) {
            for (int i = 1; i < keyStudent; i++) {
                Student s = listStudents.get(i);
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
            throw new NullPointerException("Такой группы нет в системе");
        }

        ArrayList<Lesson> lessonsList = new ArrayList<>();

        synchronized (listLesson) {
            for (int i = 1; i < keyLesson; i++) {
                Lesson l = listLesson.get(i);
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
            throw new NullPointerException("Такого учителя нет в системе");
        }

        ArrayList<Lesson> lessonsList = new ArrayList<>();

        synchronized (listLesson) {
            for (int i = 1; i < keyLesson; i++) {
                Lesson l = listLesson.get(i);
                if ((endDate.after(l.getDate())) && (startDate.before(l.getDate())) && (l.getTeacher().equals(teacher))) {
                    lessonsList.add(l);
                }
            }
        }

        return lessonsList;
    }


    public String EditLesson(Lesson lesson) {
        synchronized (listLesson) {
            getLessonById(lesson.getId());
            for (int i = 1; i < keyLesson; i++) {
                Lesson lesson0 = listLesson.get(i);
                if (lesson.equals(lesson0)) {
                    throw new NullPointerException("Такой урок уже есть в системе");
                }
            }
            listLesson.put(lesson.getId(), lesson);
        }
        return "Данные урока изменены!";
    }

    public synchronized int AddLesson(Lesson lesson) {
        synchronized (listLesson) {
            for (int i = 1; i < keyLesson; i++) {
                Lesson lesson0 = listLesson.get(i);
                if (lesson.equals(lesson0)) {
                    throw new NullPointerException("Такой урок уже есть в системе");
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
            for (int i = 1; i < keyLesson; i++) {
                Lesson lesson = listLesson.get(i);
                if (lesson.getGroup().getId() == groupId) {
                    listLesson.remove(lesson.getId());
                    if (getLessonVisitingByLessonId(lesson.getId()) != null) {
                        deleteLessonVisitingByLessonId(lesson.getId());
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

        if (getLessonVisitingByLessonId(lessonId) != null) {
            deleteLessonVisitingByLessonId(lessonId);
        }
        return "Урок удален";
    }

    public synchronized String DeleteLessonsByTeacher(int teacherId) {
        synchronized (listLesson) {
            getTeacherById(teacherId);
            for (int i = 1; i < keyLesson; i++) {
                Lesson lesson = listLesson.get(i);
                if (lesson.getTeacher().getId() == teacherId) {
                    listLesson.remove(lesson.getId());
                    if (getLessonVisitingByLessonId(lesson.getId()) != null) {
                        deleteLessonVisitingByLessonId(lesson.getId());
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
            throw new NullPointerException("Такой группы нет в системе");
        }
        return group;
    }

    public synchronized int addStudentGroup(StudentGroup group) {
        synchronized (listGroups) {
            for (int i = 1; i < keyGroup; i++) {
                StudentGroup group1 = listGroups.get(i);
                if (group1.equals(group)) {
                    throw new NullPointerException("Такая группа уже есть в системе");
                }
            }
            group.setId(keyGroup);
            listGroups.put(keyGroup, group);
            keyGroup++;
            return keyGroup - 1;
        }
    }


    public String editStudentGroup(StudentGroup group) {
        StudentGroup group0 = getStudentGroupById(group.getId());
        if (group.equals(group0)) {
            throw new NullPointerException("Новые данные совпадают с имеющимися");
        }
        synchronized (listGroups) {
            for (int i = 1; i < keyGroup; i++) {
                StudentGroup group1 = listGroups.get(i);
                if (group1.equals(group)) {
                    throw new NullPointerException("Такое название группы уже занято");
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
            throw new NullPointerException("Такого учителя нет в системе");
        }
        return teacher;
    }

    public ArrayList<Teacher> getTeachers() {
        return new ArrayList<>(listTeachers.values());
    }


    public synchronized int addTeacher(Teacher teacher) {

        synchronized (listTeachers) {
            for (int i = 1; i < keyTeacher; i++) {
                Teacher teacher0 = listTeachers.get(i);
                if (Objects.equals(teacher.getFirstName(), teacher0.getFirstName()) && (Objects.equals(teacher.getLastName(), teacher0.getLastName()))
                        && Objects.equals(teacher.getMiddleName(), teacher0.getMiddleName())) {
                    throw new NullPointerException("Такой учитель уже есть в системе");
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
            listTeachers.put(teacher.getId(), teacher);
        }
        return "Преподаватель изменен";
    }

    public synchronized String deleteTeacher(int id) {
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
            throw new NullPointerException("Такого урока нет в системе");
        }
        return subject;
    }

    public synchronized int addSubject(Subject subject) {
        synchronized (listSubjects) {
            for (int i = 1; i < keySubject; i++) {
                Subject s = listSubjects.get(i);
                if (Objects.equals(s.getName(), subject.getName())) {
                    throw new NullPointerException("Такой предмет уже есть в системе");
                }
            }
            subject.setId(keySubject);
            listSubjects.put(keySubject, subject);
        }
        keySubject++;
        return keySubject - 1;
    }


    public String editSubject(Subject subject) {
        getSubjectById(subject.getId());
        synchronized (listSubjects) {
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
        try {
            getLessonVisitingByLessonId(lessonVisiting.getLessonId());
            throw new NullPointerException("Данные о посещаемости данного урока уже есть в системе");
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

        getLessonVisitingById(lessonVisitingId);

        listLessonVisiting_LessonId.remove(listLessonVisiting_Id.get(lessonVisitingId).getLessonId());
        listLessonVisiting_Id.remove(lessonVisitingId);

        return "Посещаемость удалена";
    }

    public synchronized String deleteLessonVisitingByLessonId(int lessonId) {

        getLessonById(lessonId);
        getLessonVisitingByLessonId(lessonId);

        listLessonVisiting_Id.remove(listLessonVisiting_LessonId.get(lessonId).getId());
        listLessonVisiting_LessonId.remove(lessonId);

        return "Посещаемость удалена";
    }
}
