package org.example.dto_request.lesson;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class DeleteLessonByIdRequest {
    @Positive
    private int lessonId;
}
