package org.example.dto_response.lessonVisiting;

import java.util.Objects;

public class GetLessonVisitingByIdResponse {
    private String lessonVisiting;

    public GetLessonVisitingByIdResponse(String listLessonVisiting) {
        this.lessonVisiting = listLessonVisiting;
    }

    public GetLessonVisitingByIdResponse() {
        super();
    }

    public String getLessonVisiting() {
        return lessonVisiting;
    }

    public void setLessonVisiting(String lessonVisiting) {
        this.lessonVisiting = lessonVisiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonVisitingByIdResponse response)) return false;
        return Objects.equals(lessonVisiting, response.lessonVisiting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonVisiting);
    }
}
