package org.example.dto.dtoRequest.lessonVisiting;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class EditLessonVisitingRequest {
    @Positive
    private int lessonVisitingId;
    @Positive
    private int lessonId;
    private ArrayList<String> listStudent;
}
