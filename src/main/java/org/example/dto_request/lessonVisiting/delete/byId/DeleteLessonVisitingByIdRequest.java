package org.example.dto_request.lessonVisiting.delete.byId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class DeleteLessonVisitingByIdRequest {
    private int lessonVisitingId;

    public DeleteLessonVisitingByIdRequest(int lessonVisitingId) {
        this.lessonVisitingId = lessonVisitingId;
    }

    public DeleteLessonVisitingByIdRequest() {
    }
}
