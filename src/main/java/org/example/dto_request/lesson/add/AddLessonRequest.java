package org.example.dto_request.lesson.add;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class AddLessonRequest {
    @Pattern( regexp = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d)")
    private String date;
    @Positive
    private int number;
    @Positive
    private int teacherId;
    @Positive
    private int groupId;


    public AddLessonRequest(String date, @Positive int number,  @Positive int teacherId,  @Positive int groupId){
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
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
