package org.example;

import org.example.model.*;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
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
--
-- + Посещаемость (вся)
-- +  Урок -> Посещаемость (вся)
-- Студент -> Посещаемость (в списках студентов)
-- + Группа -> Студенты и Уроки -> Посещаемость (вся)
-- + Учитель -> Уроки -> Посещаемости (вся)
-- + Предмет -> Уроки -> Посещаемости (вся)
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

    public synchronized int addStudent(Student student) throws AddEntityMatchData {
        synchronized (listStudents) {
            for (Student s : listStudents.values()) {
                if (s.equals(student)) {
                    throw new AddEntityMatchData("Такой студент уже есть в системе");
                }
            }
            student.setId(keyStudent);
            listStudents.put(keyStudent, student);
        }
        keyStudent++;
        return keyStudent - 1;
    }

    public ArrayList<Student> getStudentsByGroup(int id) throws EntityNotFoundInDataBase {
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

    public Student getStudentById(int id) throws EntityNotFoundInDataBase {
        Student student = listStudents.get(id);
        if (isNull(student)) {
            throw new EntityNotFoundInDataBase("Такого студента нет в базе данных");
        }
        return student;
    }

    public String editStudent(Student student) throws EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict {
        synchronized (listStudents) {
            Student student1 = getStudentById(student.getId());
            if (student.equals(student1)) {
                throw new StupidChanges("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }
            for (Student s : listStudents.values()) {
                if (s.equals(student)) {
                    throw new ChangesEntityLeadToConflict("Новые данные, которые вы хотите внести совпадают с другим студентом");
                }
            }
            listStudents.put(student.getId(), student);
        }
        return "Данные студента изменены";
    }

    public synchronized String deleteStudent(int id) throws EntityNotFoundInDataBase {
        getStudentById(id);
        deleteLessonVisitingByStudent(id);
        listStudents.remove(id);
        return "Студент удален";
    }

    public void deleteStudentByGroup(int id) throws EntityNotFoundInDataBase {
        getStudentGroupById(id);

        for (Student student : listStudents.values()) {
            if (student.getGroup().getId() == id) {
                listStudents.remove(student.getId());
            }
        }
    }
    //

    //Lesson
    public Lesson getLessonById(int id) throws EntityNotFoundInDataBase {
        Lesson lesson = listLesson.get(id);
        if (isNull(lesson)) {
            throw new EntityNotFoundInDataBase("Такого урока нет в базе данных");
        }
        return lesson;
    }

    public ArrayList<Lesson> getLessonsByGroup(Date startDate, Date endDate, int groupId) throws EntityNotFoundInDataBase {
        StudentGroup group = getStudentGroupById(groupId);
        if (isNull(group)) {
            throw new EntityNotFoundInDataBase("Такой группы нет в базе данных");
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

    public ArrayList<Lesson> getLessonsByTeacher(Date startDate, Date endDate, int teacherId) throws EntityNotFoundInDataBase {
        Teacher teacher = getTeacherById(teacherId);
        if (isNull(teacher)) {
            throw new EntityNotFoundInDataBase("Такого учителя нет в базе данных");
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


    public String editLesson(Lesson lesson) throws EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict {
        synchronized (listLesson) {
            Lesson lesson1 = getLessonById(lesson.getId());
            if (lesson.equals(lesson1)) {
                throw new StupidChanges("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }

            for (Lesson l : listLesson.values()) {
                if (lesson.equals(l)) {
                    throw new ChangesEntityLeadToConflict("Новые данные, которые вы хотите внести совпадают с другим уроком");
                }
            }
            listLesson.put(lesson.getId(), lesson);
        }
        return "Данные урока изменены!";
    }

    public synchronized int addLesson(Lesson lesson) throws AddEntityMatchData {
        synchronized (listLesson) {
            for (Lesson l : listLesson.values()) {
                if (lesson.equals(l)) {
                    throw new AddEntityMatchData("Такой урок уже есть в базе данных");
                }
            }
            lesson.setId(keyLesson);
            listLesson.put(keyLesson, lesson);
        }
        keyLesson++;
        return keyLesson - 1;
    }

    public synchronized String deleteLessonsByGroup(int groupId) throws EntityNotFoundInDataBase {
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

    public synchronized String deleteLessonById(int lessonId) throws EntityNotFoundInDataBase {
        synchronized (listLesson) {
            getLessonById(lessonId);
            listLesson.remove(lessonId);
        }

        if (!isNull(getLessonVisitingByLessonId(lessonId))) {
            deleteLessonVisitingByLessonId(lessonId);
        }
        return "Урок удален";
    }

    public synchronized String deleteLessonsByTeacher(int teacherId) throws EntityNotFoundInDataBase {
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
        return "Уроки учителя удалены";
    }

    public synchronized void deleteLessonsBySubject(int subjectId) throws EntityNotFoundInDataBase {
        synchronized (listLesson) {
            getSubjectById(subjectId);
            for (Lesson l : listLesson.values()) {
                if (l.getSubject().getId() == subjectId) {
                    listLesson.remove(l.getId());
                    if (!isNull(getLessonVisitingByLessonId(l.getId()))) {
                        deleteLessonVisitingByLessonId(l.getId());
                    }
                }
            }
        }
    }
    //

    //StudentGroup
    public ArrayList<StudentGroup> getStudentGroups() {
        return new ArrayList<>(listGroups.values());
    }

    public StudentGroup getStudentGroupById(int id) throws EntityNotFoundInDataBase {
        StudentGroup group = listGroups.get(id);
        if (isNull(group)) {
            throw new EntityNotFoundInDataBase("Такой группы нет в базе данных");
        }
        return group;
    }

    public synchronized int addStudentGroup(StudentGroup group) throws AddEntityMatchData {
        synchronized (listGroups) {
            for (StudentGroup studentGroup : listGroups.values()) {
                if (studentGroup.equals(group)) {
                    throw new AddEntityMatchData("Такая группа уже есть в базе данных");
                }
            }
            group.setId(keyGroup);
            listGroups.put(keyGroup, group);
            keyGroup++;
            return keyGroup - 1;
        }
    }


    public String editStudentGroup(StudentGroup group) throws EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict {
        synchronized (listGroups) {
            StudentGroup group0 = getStudentGroupById(group.getId());
            if (group.equals(group0)) {
                throw new StupidChanges("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }
            for (StudentGroup studentGroup : listGroups.values()) {
                if (studentGroup.equals(group)) {
                    throw new ChangesEntityLeadToConflict("Новые данные, которые вы хотите внести совпадают с другой группой");
                }
            }
            listGroups.put(group.getId(), group);
            return "Группа изменена";
        }
    }

    public synchronized String deleteStudentGroup(int id) throws EntityNotFoundInDataBase {
        getStudentGroupById(id);
        deleteStudentByGroup(id);
        deleteLessonsByGroup(id);
        listGroups.remove(id);
        return "Группа удалена";
    }
    //

    //Teacher
    public Teacher getTeacherById(int id) throws EntityNotFoundInDataBase {
        Teacher teacher = listTeachers.get(id);
        if (isNull(teacher)) {
            throw new EntityNotFoundInDataBase("Такого преподавателя нет в базе данных");
        }
        return teacher;
    }

    public ArrayList<Teacher> getTeachers() {
        return new ArrayList<>(listTeachers.values());
    }


    public synchronized int addTeacher(Teacher teacher) throws AddEntityMatchData {
        synchronized (listTeachers) {
            for (Teacher teacher0 : listTeachers.values()) {
                if (teacher0.equals(teacher)) {
                    throw new AddEntityMatchData("Такой преподаватель уже есть в базе данных");
                }
            }
            teacher.setId(keyTeacher);
            listTeachers.put(keyTeacher, teacher);
        }
        keyTeacher++;
        return keyTeacher - 1;
    }


    public String editTeacher(Teacher teacher) throws EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict {
        synchronized (listTeachers) {
            Teacher teacher0 = getTeacherById(teacher.getId());
            if (teacher0.equals(teacher)) {
                throw new StupidChanges("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }
            for (Teacher t : listTeachers.values()) {
                if (t.equals(teacher)) {
                    throw new ChangesEntityLeadToConflict("Новые данные, которые вы хотите внести, совпадают с другим преподавателем");
                }
            }
            listTeachers.put(teacher.getId(), teacher);
        }
        return "Преподаватель изменен";
    }

    public synchronized String deleteTeacher(int id) throws EntityNotFoundInDataBase {
        getTeacherById(id);
        deleteLessonsByTeacher(id);
        listTeachers.remove(id);
        return "Преподаватель удален";
    }
    //

    //Subject

    public ArrayList<Subject> getSubjects() {
        return new ArrayList<>(listSubjects.values());
    }

    public Subject getSubjectById(int subjectId) throws EntityNotFoundInDataBase {
        Subject subject = listSubjects.get(subjectId);
        if (isNull(subject)) {
            throw new EntityNotFoundInDataBase("Такого урока нет в базе данных");
        }
        return subject;
    }

    public synchronized int addSubject(Subject subject) throws AddEntityMatchData {
        synchronized (listSubjects) {
            for (Subject s : listSubjects.values()) {
                if (Objects.equals(s.getName(), subject.getName())) {
                    throw new AddEntityMatchData("Такой предмет уже есть в базе данных");
                }
            }
            subject.setId(keySubject);
            listSubjects.put(keySubject, subject);
        }
        keySubject++;
        return keySubject - 1;
    }


    public String editSubject(Subject subject) throws EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict {
        synchronized (listSubjects) {
            Subject subject1 = getSubjectById(subject.getId());
            if (subject1.equals(subject)) {
                throw new StupidChanges("Новые данные, которые вы хотите внести, совпадают с имеющимися");
            }
            for (Subject s : listSubjects.values()) {
                if (s.equals(subject)) {
                    throw new ChangesEntityLeadToConflict("Новые данные, которые вы хотите внести совпадают с другим предметом");
                }
            }
            listSubjects.put(subject.getId(), subject);
        }
        return "Предмет изменен";
    }

    public synchronized String deleteSubject(int id) throws EntityNotFoundInDataBase {
        getSubjectById(id);
        deleteLessonsBySubject(id);
        listSubjects.remove(id);
        return "Предмет удален";
    }

    //

    // LessonVisiting

    public synchronized int addLessonVisiting(LessonVisiting lessonVisiting) throws EntityNotFoundInDataBase {
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

    public LessonVisiting getLessonVisitingById(int lessonVisitingId) throws EntityNotFoundInDataBase {
        LessonVisiting lessonVisiting = listLessonVisiting_Id.get(lessonVisitingId);
        if (isNull(lessonVisiting)) {
            throw new EntityNotFoundInDataBase("Данных о такой посещаемости нет в базе данных");
        }
        return lessonVisiting;
    }

    public LessonVisiting getLessonVisitingByLessonId(int lessonId) throws EntityNotFoundInDataBase {
        LessonVisiting lessonVisiting = listLessonVisiting_LessonId.get(lessonId);
        if (isNull(lessonVisiting)) {
            throw new EntityNotFoundInDataBase("Данных о такой посещаемости нет в базе данных");
        }
        return lessonVisiting;
    }


    public synchronized String editLessonVisiting(LessonVisiting lessonVisiting) throws EntityNotFoundInDataBase, StupidChanges {
        synchronized (listLessonVisiting_Id) {
            synchronized (listLessonVisiting_LessonId) {
                getLessonById(lessonVisiting.getLessonId());

                LessonVisiting lv = getLessonVisitingById(lessonVisiting.getId());

                if (lessonVisiting.equals(lv)) {
                    throw new StupidChanges("Данные о посещаемости совпадают с имеющимися");
                }

                listLessonVisiting_Id.put(lessonVisiting.getId(), lessonVisiting);

                listLessonVisiting_LessonId.put(lessonVisiting.getLessonId(), lessonVisiting);
            }
            return "Посещаемость изменена";
        }
    }

    public synchronized String deleteLessonVisitingById(int lessonVisitingId) throws EntityNotFoundInDataBase {
        synchronized (listLessonVisiting_Id) {
            synchronized (listLessonVisiting_LessonId) {
                LessonVisiting lessonVisiting = getLessonVisitingById(lessonVisitingId);
                getLessonById(lessonVisiting.getLessonId());
                int id = lessonVisiting.getLessonId();
                if (!isNull(getLessonVisitingByLessonId(id))) {
                    listLessonVisiting_LessonId.remove(id);
                }
                listLessonVisiting_Id.remove(lessonVisitingId);
            }
            return "Посещаемость удалена";
        }
    }

    public synchronized String deleteLessonVisitingByLessonId(int lessonId) throws EntityNotFoundInDataBase {
        getLessonById(lessonId);
        LessonVisiting lessonVisiting = getLessonVisitingByLessonId(lessonId);
        return deleteLessonVisitingById(lessonVisiting.getId());
    }

    public synchronized void deleteLessonVisitingByStudent(int id) {
        synchronized (listLessonVisiting_Id) {
            synchronized (listLessonVisiting_LessonId) {
                for (LessonVisiting lessonVisiting : listLessonVisiting_Id.values()) {
                    ArrayList<Student> list = lessonVisiting.getListStudent();
                    boolean flag = false;
                    for (Student student : lessonVisiting.getListStudent()) {
                        if (student.getId() == id) {
                            list.remove(student);
                            flag = true;
                        }
                    }
                    if (flag) {
                        lessonVisiting.setListStudent(list);
                        listLessonVisiting_Id.put(lessonVisiting.getId(), lessonVisiting);
                        listLessonVisiting_LessonId.put(lessonVisiting.getLessonId(), lessonVisiting);
                    }
                }
            }
        }
    }
}

