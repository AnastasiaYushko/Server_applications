package org.example.dto_request.lessonVisiting.get;

//getLessonByID
public class GetLessonVisitingRequest {
    private int lessonId;

    public GetLessonVisitingRequest(int lessonId){
        this.lessonId = lessonId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }
}
