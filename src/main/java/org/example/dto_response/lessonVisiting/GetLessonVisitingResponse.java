package org.example.dto_response.lessonVisiting;

import java.util.Objects;

public class GetLessonVisitingResponse {
    private String lessonVisiting;

    public GetLessonVisitingResponse(String listLessonVisiting){
        this.lessonVisiting = listLessonVisiting;
    }

    public GetLessonVisitingResponse(){
        super();
    }

    public String getListLessonVisiting() {
        return lessonVisiting;
    }

    public void setListLessonVisiting(String listLessonVisiting) {
        this.lessonVisiting = lessonVisiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonVisitingResponse response)) return false;
        return Objects.equals(lessonVisiting, response.lessonVisiting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonVisiting);
    }
}
