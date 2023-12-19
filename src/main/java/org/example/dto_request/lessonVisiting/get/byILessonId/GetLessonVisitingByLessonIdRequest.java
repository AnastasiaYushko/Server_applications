package org.example.dto_request.lessonVisiting.get.byILessonId;

public class GetLessonVisitingByLessonIdRequest {

    private int lessonId;

    public GetLessonVisitingByLessonIdRequest(int lessonId) {
        this.lessonId = lessonId;
    }

    public GetLessonVisitingByLessonIdRequest() {
        super();
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }
}
