package org.example.dtoRequest.lesson;

import jakarta.validation.constraints.Pattern;
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
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class EditLessonRequest {
    @Positive
    private int id;
    @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))")
    private String date;
    @Positive
    private int number;
    @Positive
    private int teacherId;
    @Positive
    private int groupId;
    @Positive
    private int subjectId;
}
