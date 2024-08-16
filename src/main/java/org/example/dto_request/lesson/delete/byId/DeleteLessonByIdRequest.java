package org.example.dto_request.lesson.delete.byId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Positive;

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
