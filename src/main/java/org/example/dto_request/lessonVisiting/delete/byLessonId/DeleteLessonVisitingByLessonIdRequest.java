package org.example.dto_request.lessonVisiting.delete.byLessonId;

import javax.validation.constraints.Positive;

public class DeleteLessonVisitingByLessonIdRequest {
    @Positive
    private int lessonId;

    public DeleteLessonVisitingByLessonIdRequest(@Positive int lessonId) {
        this.lessonId = lessonId;
    }

    public DeleteLessonVisitingByLessonIdRequest() {
        super();
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(@Positive int lessonId) {
        this.lessonId = lessonId;
    }
}
