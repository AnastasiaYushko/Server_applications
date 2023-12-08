package org.example.dto_request.lesson.delete.byId;

import javax.validation.constraints.Positive;

public class DeleteLessonByIdRequest {
    @Positive
    private int lessonId;

    public DeleteLessonByIdRequest(@Positive int lessonId){
        this.lessonId = lessonId;
    }

    public void setLessonId( @Positive int lessonId) {
        this.lessonId = lessonId;
    }

    public int getLessonId() {
        return lessonId;
    }

}
