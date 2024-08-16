package org.example.dto_request.lessonVisiting.delete.byId;

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
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class DeleteLessonVisitingByIdRequest {
    @Positive
    private int lessonVisitingId;
}
