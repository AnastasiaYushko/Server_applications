/*
package org.example.dto_response.lesson;

import java.util.Objects;

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

    public EditLessonResponse(){
        super();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EditLessonResponse that)) return false;
        return getNumber() == that.getNumber() && getTeacherId() == that.getTeacherId() && getGroupId() == that.getGroupId() && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getNumber(), getTeacherId(), getGroupId());
    }
}
*/
