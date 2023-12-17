package org.example.dto_request.lessonVisiting.delete;

import javax.validation.constraints.Positive;

public class DeleteLessonVisitingRequest {
    @Positive
    private int lessonId;

    public DeleteLessonVisitingRequest(@Positive int lessonId){
        this.lessonId = lessonId;
    }

    public DeleteLessonVisitingRequest(){
        super();
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId( @Positive int lessonId) {
        this.lessonId = lessonId;
    }
}
