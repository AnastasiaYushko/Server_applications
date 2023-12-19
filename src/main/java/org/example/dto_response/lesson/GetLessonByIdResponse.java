package org.example.dto_response.lesson;

import java.util.Objects;

public class GetLessonByIdResponse {
    private String date;
    private int number;
    private int teacherId;
    private int groupId;

    public GetLessonByIdResponse(String date, int number, int teacherId, int groupId) {
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public GetLessonByIdResponse() {
        super();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonByIdResponse that)) return false;
        return getNumber() == that.getNumber() && getTeacherId() == that.getTeacherId() && groupId == that.groupId && getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getNumber(), getTeacherId(), groupId);
    }
}
