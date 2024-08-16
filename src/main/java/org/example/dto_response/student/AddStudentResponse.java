package org.example.dto_response.student;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class AddStudentResponse {
    private int id;
}
