package org.example.dto_request.lessonVisiting.delete.byId;

import javax.validation.constraints.Positive;

public class DeleteLessonVisitingByIdRequest {
    @Positive
    private int lessonVisitingId;

    public DeleteLessonVisitingByIdRequest(@Positive int lessonVisitingId) {
        this.lessonVisitingId = lessonVisitingId;
    }

    public DeleteLessonVisitingByIdRequest() {
        super();
    }

    public int getLessonVisitingId() {
        return lessonVisitingId;
    }

    public void setLessonVisitingId(@Positive int lessonVisitingId) {
        this.lessonVisitingId = lessonVisitingId;
    }
}
