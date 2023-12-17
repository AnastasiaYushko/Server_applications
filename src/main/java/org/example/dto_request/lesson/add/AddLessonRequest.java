package org.example.dto_request.lesson.add;

public class AddLessonRequest {

    private String date;
    private int number;
    private int teacherId;
    private int groupId;


    public AddLessonRequest(String date, int number, int teacherId, int groupId) {
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public AddLessonRequest() {
        super();
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getTeacherId() {
        return teacherId;
    }
}
