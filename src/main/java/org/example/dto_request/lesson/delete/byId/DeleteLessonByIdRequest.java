package org.example.dto_request.lesson.delete.byId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class DeleteLessonByIdRequest {
    private int lessonId;

    public DeleteLessonByIdRequest(int lessonId) {
        this.lessonId = lessonId;
    }

    public DeleteLessonByIdRequest() {
    }
}
