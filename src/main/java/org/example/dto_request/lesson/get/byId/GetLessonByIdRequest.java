package org.example.dto_request.lesson.get.byId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class GetLessonByIdRequest {
    private int lessonId;

    public GetLessonByIdRequest(int lessonId) {
        this.lessonId = lessonId;
    }

    public GetLessonByIdRequest() {
    }
}
