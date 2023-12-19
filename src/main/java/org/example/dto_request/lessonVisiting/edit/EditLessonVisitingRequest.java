package org.example.dto_request.lessonVisiting.edit;

import javax.validation.constraints.Positive;
import java.util.ArrayList;

public class EditLessonVisitingRequest {
    @Positive
    private int lessonVisitingId;
    @Positive
    private int lessonId;
    private ArrayList<String> listStudent;

    public EditLessonVisitingRequest(@Positive int lessonVisitingId,@Positive int lessonId, ArrayList<String> listStudent) {
        this.lessonId = lessonId;
        this.listStudent = new ArrayList<>(listStudent);
        this.lessonVisitingId = lessonVisitingId;
    }

    public EditLessonVisitingRequest() {
        super();
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

    public int getLessonVisitingId() {
        return lessonVisitingId;
    }

    public void setLessonVisitingId(int lessonVisitingId) {
        this.lessonVisitingId = lessonVisitingId;
    }
}
