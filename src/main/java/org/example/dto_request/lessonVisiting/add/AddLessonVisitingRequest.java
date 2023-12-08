package org.example.dto_request.lessonVisiting.add;

import javax.validation.constraints.Positive;
import java.util.ArrayList;

public class AddLessonVisitingRequest {
    @Positive
    private int lessonId;
    private ArrayList<String> listStudent;

    public AddLessonVisitingRequest(@Positive int lessonId,ArrayList<String> listStudent){
        this.lessonId = lessonId;
        this.listStudent = new ArrayList<>(listStudent);
    }

    public ArrayList<String> getListStudent() {
        return listStudent;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setListStudent(ArrayList<String> listStudent) {
        this.listStudent = new ArrayList<>(listStudent);
    }
}
