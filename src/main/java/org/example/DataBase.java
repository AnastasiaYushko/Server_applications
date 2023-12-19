package org.example;

import org.example.model.*;

import java.util.*;

public class DataBase {

    private static  DataBase dataBase;

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
    private final Map<Integer, LessonVisiting> listLessonVisiting;
    private Integer keyLessonVisiting;

    private DataBase() {
        keyStudent = 1;
        keyGroup = 1;
        keyTeacher = 1;
        keySubject = 1;
        keyLesson = 1;
        keyLessonVisiting = 1;

        listStudents = new HashMap<>();
        listGroups = new HashMap<>();
        listTeachers = new HashMap<>();
        listSubjects = new HashMap<>();
        listLesson = new HashMap<>();
        listLessonVisiting = new HashMap<>();

    }

    public static DataBase getDataBase() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public void clear() {
        dataBase.listTeachers.clear();
        dataBase.listStudents.clear();
        dataBase.listGroups.clear();
        dataBase.listSubjects.clear();
        dataBase.listLesson.clear();
        dataBase.listLessonVisiting.clear();

        keyStudent = 1;
        keyGroup = 1;
        keyTeacher = 1;
        keySubject = 1;
        keyLesson = 1;
        keyLessonVisiting = 1;

        dataBase = null;
    }

    //Student
    public int addStudent(Student student) {
        student.setId(keyStudent);
        listStudents.put(keyStudent, student);
        keyStudent++;
        return keyStudent-1;
    }

    public ArrayList<Student> getStudentsByGroup(int id) {
        ArrayList<Student> answerBase = new ArrayList<>();

        ArrayList<Student> students = new ArrayList<>(listStudents.values());
        for (Student s : students) {
            int idGroup = s.getGroup().getId();
            if (idGroup == id) {
                answerBase.add(s);
            }
        }

        return answerBase;
    }

    public Student getStudentById(int id) {
        return listStudents.get(id);
    }

    public void editStudent(Student student) {
        listStudents.put(student.getId(), student);
    }

    public void deleteStudent(int id) {
        listStudents.remove(id);
    }
    //

    //Lesson
    public Lesson getLessonById(int id) {
        return listLesson.get(id);
    }

    public ArrayList<Lesson> getLessonsByGroup(Date startDate, Date endDate, StudentGroup group){

        ArrayList<Lesson> lessonsList = new ArrayList<>();

        ArrayList<Lesson> lessons = new ArrayList<>(listLesson.values());
        for (Lesson l : lessons) {
            if ((endDate.after(l.getDate()) || endDate.equals(l.getDate())) && (startDate.before(l.getDate()) || endDate.equals(l.getDate()) && (l.getGroup().equals(group)))) {
                lessonsList.add(l);
            }
        }

        return lessonsList;
    }

    public ArrayList<Lesson> getLessonsByTeacher(Date startDate, Date endDate, Teacher teacher) {
        ArrayList<Lesson> lessonsList = new ArrayList<>();

        ArrayList<Lesson> lessons = new ArrayList<>(listLesson.values());
        for (Lesson l : lessons) {
            if ((endDate.after(l.getDate())) && (startDate.before(l.getDate())) && (l.getTeacher().equals(teacher))) {
                lessonsList.add(l);
            }
        }

        return lessonsList;
    }

    public void EditLesson(Lesson lesson)  {
        listLesson.put(lesson.getId(), lesson);
    }

    public int AddLesson(Lesson lesson) {
        lesson.setId(keyLesson);
        listLesson.put(keyLesson, lesson);
        keyLesson++;
        return keyLesson-1;
    }

    public void DeleteLessonsByGroup(int groupId) {

        ArrayList<Lesson> lessons = new ArrayList<>(listLesson.values());

        for (Lesson lesson : lessons) {
            if (lesson.getGroup().getId() == groupId) {
                listLesson.remove(lesson.getId());
            }
        }
    }

    public void DeleteLessonById(int lessonId) {
        listLesson.remove(lessonId);
    }

    public void DeleteLessonsByTeacher(int teacherId) {
        ArrayList<Lesson> lessons = new ArrayList<>(listLesson.values());

        for (Lesson lesson : lessons) {
            if (lesson.getTeacher().getId() == teacherId) {
                listLesson.remove(lesson.getId());
            }
        }
    }
    //

    //StudentGroup
    public ArrayList<StudentGroup> getStudentGroups() {
        return new ArrayList<>(listGroups.values());
    }

    public StudentGroup getStudentGroupById(int id) {
        return listGroups.get(id);
    }

    public int addStudentGroup(StudentGroup group) {
        group.setId(keyGroup);
        listGroups.put(keyGroup, group);
        keyGroup++;
        return keyGroup-1;
    }

    public void editStudentGroup(StudentGroup group) {
        listGroups.put(group.getId(), group);
    }

    public void deleteStudentGroup(int id) {
        listGroups.remove(id);
    }
    //

    //Teacher
    public Teacher getTeacherById(int id) {
        return listTeachers.get(id);
    }

    public ArrayList<Teacher> getTeachers() {
        return new ArrayList<>(listTeachers.values());
    }

    public int addTeacher(Teacher teacher) {
        teacher.setId(keyTeacher);
        listTeachers.put(keyTeacher, teacher);
        keyTeacher++;
        return keyTeacher-1;
    }

    public void editTeacher(Teacher teacher) {
        listTeachers.put(teacher.getId(), teacher);
    }

    public void deleteTeacher(int id) {
        listTeachers.remove(id);
    }
    //

    //Subject

    public ArrayList<Subject> getSubjects() {
        return new ArrayList<>(listSubjects.values());
    }

    public Subject getSubjectById(int id) {
        return listSubjects.get(id);
    }

    public int addSubject(Subject subject) {
        subject.setId(keySubject);
        listSubjects.put(keySubject, subject);
        keySubject++;
        return keySubject-1;
    }

    public void editSubject(Subject subject) {
        listSubjects.put(subject.getId(), subject);
    }

    public void deleteSubject(int id) {
        listSubjects.remove(id);
    }

    //

    // LessonVisiting
    public void addLessonVisiting(LessonVisiting lessonVisiting) {
        lessonVisiting.setId(keyLessonVisiting);
        listLessonVisiting.put(keyLessonVisiting, lessonVisiting);
        keyLessonVisiting++;
    }

    public LessonVisiting getLessonVisiting(int lessonId) {
        ArrayList<LessonVisiting> lessonVisitingArrayList = new ArrayList<>(listLessonVisiting.values());
        LessonVisiting result = null;

        for (LessonVisiting lessonVisiting : lessonVisitingArrayList) {
            if (lessonVisiting.getLesson() == lessonId) {
                result = lessonVisiting;
            }
        }

        return result;
    }

    public void deleteLessonVisiting(int lessonId) {
        LessonVisiting lessonVisiting = dataBase.getLessonVisiting(lessonId);
        listLessonVisiting.remove(lessonVisiting.getId());
    }
}
