package org.example;

import org.example.model.*;
import org.example.myExceptions.*;

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
-- Посещаемость (вся) +
-- Урок -> Посещаемость (вся) +
-- Студент -> Посещаемость (в списках студентов) +
-- Группа -> Студенты и Уроки -> Посещаемость (вся)
-- Учитель -> Уроки -> Посещаемости (вся)
-- Предмет -> Уроки -> Посещаемости (вся)
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

    //Student

    public synchronized int addStudent(Student student) throws AddEntityMatchData {
        synchronized (listStudents) {
            for (Student s : listStudents.values()) {
                if (s.equalsWithoutId(student)) {
                    throw new AddEntityMatchData();
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
            throw new EntityNotFoundInDataBase("Student");
        }
        return student;
    }

    public String editStudent(Student student) throws EntityNotFoundInDataBase, StupidChanges, ChangesEntityLeadToConflict {
        synchronized (listStudents) {
            Student student1 = getStudentById(student.getId());
            if (student.equalsWithoutId(student1)) {
                throw new StupidChanges();
            }
            for (Student s : listStudents.values()) {
                if (s.equalsWithoutId(student)) {
                    throw new ChangesEntityLeadToConflict();
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

    // это доп метод
    public void deleteStudentByGroup(int id) throws EntityNotFoundInDataBase {
        getStudentGroupById(id);
        listStudents.values().removeIf(student -> student.getGroup().getId() == id);
    }
    //

    //Lesson
    public Lesson getLessonById(int id) throws EntityNotFoundInDataBase {
        Lesson lesson = listLesson.get(id);
        if (isNull(lesson)) {
            throw new EntityNotFoundInDataBase("Lesson");
        }
        return lesson;
    }

    public ArrayList<Lesson> getLessonsByGroup(Date startDate, Date endDate, int groupId) throws EntityNotFoundInDataBase {
        StudentGroup group = getStudentGroupById(groupId);
        if (isNull(group)) {
            throw new EntityNotFoundInDataBase("StudentGroup");
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
            throw new EntityNotFoundInDataBase("Teacher");
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
            if (lesson.equalsWithoutId(lesson1)) {
                throw new StupidChanges();
            }

            for (Lesson l : listLesson.values()) {
                if (lesson.equalsWithoutId(l)) {
                    throw new ChangesEntityLeadToConflict();
                }
            }
            listLesson.put(lesson.getId(), lesson);
        }
        return "Данные урока изменены!";
    }

    public synchronized int addLesson(Lesson lesson) throws AddEntityMatchData {
        synchronized (listLesson) {
            for (Lesson l : listLesson.values()) {
                if (lesson.equalsWithoutId(l)) {
                    throw new AddEntityMatchData();
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
            Iterator<Lesson> iterator = listLesson.values().iterator();

            while (iterator.hasNext()) {
                Lesson l = iterator.next();
                if (l.getGroup().getId() == groupId) {
                    if (!isNull(listLessonVisiting_LessonId.get(l.getId()))) {
                        deleteLessonVisitingByLessonId(l.getId());
                    }
                    iterator.remove();
                }
            }
        }
        return "Уроки у группы удалены!";
    }

    public synchronized String deleteLessonById(int lessonId) throws EntityNotFoundInDataBase {
        synchronized (listLesson) {
            getLessonById(lessonId);

            if (!isNull(listLessonVisiting_LessonId.get(lessonId))) {
                deleteLessonVisitingByLessonId(lessonId);
            }
            listLesson.remove(lessonId);
        }
        return "Урок удален";
    }

    public synchronized String deleteLessonsByTeacher(int teacherId) throws EntityNotFoundInDataBase {
        synchronized (listLesson) {
            getTeacherById(teacherId);
            Iterator<Lesson> iterator = listLesson.values().iterator();
            while (iterator.hasNext()) {
                Lesson l = iterator.next();
                if (l.getTeacher().getId() == teacherId) {
                    if (!isNull(listLessonVisiting_LessonId.get(l.getId()))) {
                        deleteLessonVisitingByLessonId(l.getId());
                    }
                    iterator.remove();
                }
            }
        }
        return "Уроки учителя удалены";
    }

    public synchronized void deleteLessonsBySubject(int subjectId) throws EntityNotFoundInDataBase {
        synchronized (listLesson) {
            getSubjectById(subjectId);
            Iterator<Lesson> iterator = listLesson.values().iterator();
            while (iterator.hasNext()) {
                Lesson l = iterator.next();
                if (l.getSubject().getId() == subjectId) {
                    if (!isNull(getLessonVisitingByLessonId(l.getId()))) {
                        deleteLessonVisitingByLessonId(l.getId());
                    }
                    iterator.remove();
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
            throw new EntityNotFoundInDataBase("StudentGroup");
        }
        return group;
    }

    public synchronized int addStudentGroup(StudentGroup group) throws AddEntityMatchData {
        synchronized (listGroups) {
            for (StudentGroup studentGroup : listGroups.values()) {
                if (studentGroup.equalsWithoutId(group)) {
                    throw new AddEntityMatchData();
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
            if (group.equalsWithoutId(group0)) {
                throw new StupidChanges();
            }
            for (StudentGroup studentGroup : listGroups.values()) {
                if (studentGroup.equalsWithoutId(group)) {
                    throw new ChangesEntityLeadToConflict();
                }
            }
            listGroups.put(group.getId(), group);
            return "Группа изменена";
        }
    }

    public synchronized String deleteStudentGroup(int id) throws EntityNotFoundInDataBase {
        getStudentGroupById(id);
        deleteLessonsByGroup(id);
        deleteStudentByGroup(id);
        listGroups.remove(id);
        return "Группа удалена";
    }
    //

    //Teacher
    public Teacher getTeacherById(int id) throws EntityNotFoundInDataBase {
        Teacher teacher = listTeachers.get(id);
        if (isNull(teacher)) {
            throw new EntityNotFoundInDataBase("Teacher");
        }
        return teacher;
    }

    public ArrayList<Teacher> getTeachers() {
        return new ArrayList<>(listTeachers.values());
    }


    public synchronized int addTeacher(Teacher teacher) throws AddEntityMatchData {
        synchronized (listTeachers) {
            for (Teacher teacher0 : listTeachers.values()) {
                if (teacher0.equalsWithoutId(teacher)) {
                    throw new AddEntityMatchData();
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
            if (teacher0.equalsWithoutId(teacher)) {
                throw new StupidChanges();
            }
            for (Teacher t : listTeachers.values()) {
                if (t.equalsWithoutId(teacher)) {
                    throw new ChangesEntityLeadToConflict();
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
            throw new EntityNotFoundInDataBase("Subject");
        }
        return subject;
    }

    public synchronized int addSubject(Subject subject) throws AddEntityMatchData {
        synchronized (listSubjects) {
            for (Subject s : listSubjects.values()) {
                if (Objects.equals(s.getName(), subject.getName())) {
                    throw new AddEntityMatchData();
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
            if (subject1.equalsWithoutId(subject)) {
                throw new StupidChanges();
            }
            for (Subject s : listSubjects.values()) {
                if (s.equalsWithoutId(subject)) {
                    throw new ChangesEntityLeadToConflict();
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

    public synchronized int addLessonVisiting(LessonVisiting lessonVisiting) throws EntityNotFoundInDataBase, AddEntityMatchData, ConflictingData {
        checkStudents(lessonVisiting);
        getLessonById(lessonVisiting.getLessonId());

        try {
            getLessonVisitingByLessonId(lessonVisiting.getLessonId());
            throw new AddEntityMatchData();
        } catch (EntityNotFoundInDataBase e) {
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
            throw new EntityNotFoundInDataBase("LessonVisiting");
        }
        return lessonVisiting;
    }

    public LessonVisiting getLessonVisitingByLessonId(int lessonId) throws EntityNotFoundInDataBase {
        LessonVisiting lessonVisiting = listLessonVisiting_LessonId.get(lessonId);
        if (isNull(lessonVisiting)) {
            throw new EntityNotFoundInDataBase("LessonVisiting");
        }
        return lessonVisiting;
    }


    public synchronized String editLessonVisiting(LessonVisiting lessonVisiting) throws EntityNotFoundInDataBase, StupidChanges, ConflictingData {
        checkStudents(lessonVisiting);

        // проверка связи LessonId и LessonVisitingId
        if (getLessonById(lessonVisiting.getId()).getId() != lessonVisiting.getLessonId()) {
            throw new ConflictingData("Посещаемость, которую хотите изменить, не относится к заданному вами уроку");
        }


        for (Student student : lessonVisiting.getListStudent()) {
            getStudentById(student.getId());
        }
        synchronized (listLessonVisiting_Id) {
            synchronized (listLessonVisiting_LessonId) {
                getLessonById(lessonVisiting.getLessonId());

                LessonVisiting lv = getLessonVisitingById(lessonVisiting.getId());

                if (lessonVisiting.equals(lv)) {
                    throw new StupidChanges();
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

    //
    public synchronized void deleteLessonVisitingByStudent(int id) {
        synchronized (listLessonVisiting_Id) {
            synchronized (listLessonVisiting_LessonId) {
                for (LessonVisiting lessonVisiting : listLessonVisiting_Id.values()) {
                    ArrayList<Student> list = lessonVisiting.getListStudent();
                    boolean flag = false;

                    Iterator<Student> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        Student student = iterator.next();
                        if (student.getId() == id) {
                            iterator.remove();
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

    public void checkStudents(LessonVisiting lessonVisiting) throws EntityNotFoundInDataBase, ConflictingData {
        synchronized (listStudents) {
            // избегаем добавления несущ.студентов (с различной информацией в том числе)
            for (Student student : lessonVisiting.getListStudent()) {
                int id = student.getId();
                if (!getStudentById(id).equals(student)) {
                    throw new ConflictingData("Неверные данные у студента с id = " + id);
                }
                // проверка что студент из той же группы, что и урок
                StudentGroup studentGroup = getLessonById(lessonVisiting.getLessonId()).getGroup();
                if (studentGroup.getId() != student.getGroup().getId()) {
                    throw new ConflictingData("Студент (id = " + id + ") не входит в группу " + studentGroup.getName());
                }
            }
        }
    }
}

