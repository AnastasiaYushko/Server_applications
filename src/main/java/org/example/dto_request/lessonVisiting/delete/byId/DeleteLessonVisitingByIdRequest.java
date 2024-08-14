package org.example.dto_request.lessonVisiting.delete.byId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
public class DeleteLessonVisitingByIdRequest {
    private int lessonVisitingId;

    public DeleteLessonVisitingByIdRequest(int lessonVisitingId) {
        this.lessonVisitingId = lessonVisitingId;
    }

    public DeleteLessonVisitingByIdRequest() {
    }
}
