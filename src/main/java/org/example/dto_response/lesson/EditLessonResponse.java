package org.example.dto_response.lesson;

//показать как выглядят новые данные
public class EditLessonResponse {
    private String date;
    private int number;
    private int teacherId;
    private int groupId;

    public EditLessonResponse(String date,int number,int teacherId,int groupId){
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public String getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
