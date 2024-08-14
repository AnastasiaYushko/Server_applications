package org.example.dto_request.lessonVisiting.delete.byLessonId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
public class DeleteLessonVisitingByLessonIdRequest {
    private int lessonId;

    public DeleteLessonVisitingByLessonIdRequest(int lessonId) {
        this.lessonId = lessonId;
    }

    public DeleteLessonVisitingByLessonIdRequest() {
    }
}
