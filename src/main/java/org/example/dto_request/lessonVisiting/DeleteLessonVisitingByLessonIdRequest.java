package org.example.dto_request.lessonVisiting;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
public class DeleteLessonVisitingByLessonIdRequest {
    @Positive
    private int lessonId;
}
