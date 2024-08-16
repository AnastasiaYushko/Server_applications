package org.example.dto_request.lessonVisiting.edit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
    @NotNull
    private ArrayList<String> listStudent;
}
