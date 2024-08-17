package org.example.dto.dtoResponse.student;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class AddStudentResponse {
    private int id;
}
