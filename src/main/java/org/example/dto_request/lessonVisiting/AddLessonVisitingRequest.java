package org.example.dto_request.lessonVisiting;

import jakarta.validation.constraints.NotNull;
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
public class AddLessonVisitingRequest {
    @Positive
    private int lessonId;
    @NotNull
    private ArrayList<String> listStudent;
}