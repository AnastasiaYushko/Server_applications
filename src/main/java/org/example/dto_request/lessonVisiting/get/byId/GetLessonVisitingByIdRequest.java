package org.example.dto_request.lessonVisiting.get.byId;

public class GetLessonVisitingByIdRequest {
    private int lessonVisitingId;

    public GetLessonVisitingByIdRequest(int lessonVisitingId) {
        this.lessonVisitingId = lessonVisitingId;
    }

    public GetLessonVisitingByIdRequest() {
        super();
    }

    public int getLessonVisitingId() {
        return lessonVisitingId;
    }

    public void setLessonVisitingId(int lessonVisitingId) {
        this.lessonVisitingId = lessonVisitingId;
    }
}
