package org.example.dto_request.lesson.edit;

public class EditLessonRequest {
    private int id;
    private String date;
    private int number;
    private int teacherId;
    private int groupId;

    public EditLessonRequest(int id, String date, int number, int teacherId, int groupId) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public EditLessonRequest() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
