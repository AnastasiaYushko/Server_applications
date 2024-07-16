package org.example.dto_request.lessonVisiting.get.byILessonId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class GetLessonVisitingByLessonIdRequest {

    private int lessonId;

    public GetLessonVisitingByLessonIdRequest(int lessonId) {
        this.lessonId = lessonId;
    }

    public GetLessonVisitingByLessonIdRequest() {
    }
}
