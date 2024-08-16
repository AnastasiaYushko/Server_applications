package org.example.dto_request.lessonVisiting.delete.byLessonId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Positive;

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
