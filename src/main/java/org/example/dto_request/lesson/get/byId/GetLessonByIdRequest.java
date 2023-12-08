package org.example.dto_request.lesson.get.byId;

import javax.validation.constraints.Positive;

//без посещаемости
public class GetLessonByIdRequest {
    @Positive
    private int lessonId;

    public GetLessonByIdRequest(@Positive int lessonId){
        this.lessonId = lessonId;
    }

    public void setLessonId(@Positive int lessonId) {
        this.lessonId = lessonId;
    }

    public int getLessonId() {
        return lessonId;
    }
}
