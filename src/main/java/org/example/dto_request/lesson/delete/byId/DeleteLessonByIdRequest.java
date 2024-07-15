package org.example.dto_request.lesson.delete.byId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class DeleteLessonByIdRequest {
    private int lessonId;

    public DeleteLessonByIdRequest(int lessonId) {
        this.lessonId = lessonId;
    }

    public DeleteLessonByIdRequest() {
        super();
    }

}
