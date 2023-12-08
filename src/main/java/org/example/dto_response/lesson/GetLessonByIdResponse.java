package org.example.dto_response.lesson;

import java.util.ArrayList;

public class GetLessonByIdResponse {
    private String date;
    private int number;
    private int teacherId;
    private int groupId;
    private ArrayList<String> students;

    public GetLessonByIdResponse(String date,int number,int teacherId,int groupId,ArrayList<String> students) {
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.students = new ArrayList<>(students);
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public int getNameGroup() {
        return groupId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNameGroup(int groupId) {
        this.groupId = groupId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setStudents(ArrayList<String> students) {
        this.students = new ArrayList<>(students);
    }
}
