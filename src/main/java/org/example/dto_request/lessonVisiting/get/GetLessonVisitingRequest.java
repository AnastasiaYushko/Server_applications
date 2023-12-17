package org.example.dto_request.lessonVisiting.get;

public class GetLessonVisitingRequest {
    private int lessonId;

    public GetLessonVisitingRequest(int lessonId) {
        this.lessonId = lessonId;
    }

    public GetLessonVisitingRequest() {
        super();
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }
}
