package org.example.dto.dtoResponse.lesson;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class GetLessonByIdResponse {
    private String date;
    private int number;
    private int teacherId;
    private int groupId;
    private int subjectId;
}
