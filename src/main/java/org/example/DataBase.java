package org.example;

import org.example.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("data_base")
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
        student.setId(keyStudent);
        synchronized (listStudents) {
            listStudents.put(keyStudent, student);
        }
        keyStudent++;
        return keyStudent--;
    }

    public ArrayList<Student> getStudentsByGroup(int id) {
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
        return listStudents.get(id);
    }

    public void editStudent(Student student) {
        synchronized (listStudents) {
            listStudents.put(student.getId(), student);
        }
    }

    public void deleteStudent(int id) {
        synchronized (listStudents) {
            listStudents.remove(id);
        }
    }
    //

    //Lesson
    public Lesson getLessonById(int id) {
        return listLesson.get(id);
    }

    public ArrayList<Lesson> getLessonsByGroup(Date startDate, Date endDate, StudentGroup group) {

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

    public ArrayList<Lesson> getLessonsByTeacher(Date startDate, Date endDate, Teacher teacher) {
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


    public void EditLesson(Lesson lesson) {
        synchronized (listLesson) {
            listLesson.put(lesson.getId(), lesson);
        }
    }


    public synchronized int AddLesson(Lesson lesson) {
        lesson.setId(keyLesson);
        synchronized (listLesson) {
            listLesson.put(keyLesson, lesson);
        }
        keyLesson++;
        return keyLesson--;
    }

    public void DeleteLessonsByGroup(int groupId) {
        synchronized (listLesson) {
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
    }

    public void DeleteLessonById(int lessonId) {
        synchronized (listLesson) {
            listLesson.remove(lessonId);
        }
        if (getLessonVisitingByLessonId(lessonId) != null) {
            deleteLessonVisitingByLessonId(lessonId);
        }
    }

    public void DeleteLessonsByTeacher(int teacherId) {
        synchronized (listLesson) {
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
    }
    //

    //StudentGroup
    public ArrayList<StudentGroup> getStudentGroups() {
        return (ArrayList<StudentGroup>) listGroups.values();
    }

    public StudentGroup getStudentGroupById(int id) {
        return listGroups.get(id);
    }

    public synchronized int addStudentGroup(StudentGroup group) {
        group.setId(keyGroup);
        synchronized (listGroups) {
            listGroups.put(keyGroup, group);
        }
        keyGroup++;
        return keyGroup--;
    }


    public void editStudentGroup(StudentGroup group) {
        synchronized (listGroups) {
            listGroups.put(group.getId(), group);
        }
    }

    public void deleteStudentGroup(int id) {
        synchronized (listGroups) {
            listGroups.remove(id);
        }
    }
    //

    //Teacher
    public Teacher getTeacherById(int id) {
        return listTeachers.get(id);
    }

    public ArrayList<Teacher> getTeachers() {
        return (ArrayList<Teacher>) listTeachers.values();
    }


    public synchronized int addTeacher(Teacher teacher) {
        teacher.setId(keyTeacher);
        synchronized (listTeachers) {
            listTeachers.put(keyTeacher, teacher);
        }
        keyTeacher++;
        return keyTeacher--;
    }


    public void editTeacher(Teacher teacher) {
        synchronized (listTeachers) {
            listTeachers.put(teacher.getId(), teacher);
        }
    }

    public void deleteTeacher(int id) {
        synchronized (listTeachers) {
            listTeachers.remove(id);
        }
    }
    //

    //Subject

    public ArrayList<Subject> getSubjects() {
        return (ArrayList<Subject>) listSubjects.values();
    }

    public Subject getSubjectById(int id) {
        return listSubjects.get(id);
    }

    public synchronized int addSubject(Subject subject) {
        synchronized (listSubjects) {
            for (int i = 1; i < keySubject; i++) {
                Subject s = listSubjects.get(i);
                if (Objects.equals(s.getName(), subject.getName())) {
                    return -1;
                }
            }
            subject.setId(keySubject);
            listSubjects.put(keySubject, subject);
        }
        keySubject++;
        return keySubject--;
    }


    public void editSubject(Subject subject) {
        synchronized (listSubjects) {
            listSubjects.put(subject.getId(), subject);
        }
    }

    public void deleteSubject(int id) {
        synchronized (listSubjects) {
            listSubjects.remove(id);
        }
    }

    //

    // LessonVisiting

    public synchronized int addLessonVisiting(LessonVisiting lessonVisiting) {
        lessonVisiting.setId(keyLessonVisiting_Id);
        synchronized (listLessonVisiting_Id) {
            listLessonVisiting_Id.put(keyLessonVisiting_Id, lessonVisiting);
        }
        synchronized (listLessonVisiting_LessonId) {
            listLessonVisiting_LessonId.put(lessonVisiting.getLessonId(), lessonVisiting);
        }
        keyLessonVisiting_Id++;
        return keyLessonVisiting_Id--;
    }

    public LessonVisiting getLessonVisitingById(int lessonVisitingId) {
        return listLessonVisiting_Id.get(lessonVisitingId);
    }

    public LessonVisiting getLessonVisitingByLessonId(int lessonId) {
        return listLessonVisiting_LessonId.get(lessonId);
    }


    public synchronized void editLessonVisiting(LessonVisiting lessonVisiting) {
        listLessonVisiting_Id.put(lessonVisiting.getId(), lessonVisiting);
        listLessonVisiting_LessonId.put(lessonVisiting.getLessonId(), lessonVisiting);
    }

    public synchronized void deleteLessonVisitingById(int lessonVisitingId) {
        listLessonVisiting_LessonId.remove(listLessonVisiting_Id.get(lessonVisitingId).getLessonId());
        listLessonVisiting_Id.remove(lessonVisitingId);
    }

    public synchronized void deleteLessonVisitingByLessonId(int lessonId) {
        listLessonVisiting_Id.remove(listLessonVisiting_LessonId.get(lessonId).getId());
        listLessonVisiting_LessonId.remove(lessonId);
    }
}
