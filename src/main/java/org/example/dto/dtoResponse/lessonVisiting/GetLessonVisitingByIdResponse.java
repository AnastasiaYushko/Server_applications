package org.example.dto.dtoResponse.lessonVisiting;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class GetLessonVisitingByIdResponse {
    private String lessonVisiting;
}
