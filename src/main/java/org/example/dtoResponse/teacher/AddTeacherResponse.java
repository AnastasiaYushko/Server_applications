package org.example.dtoResponse.teacher;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class AddTeacherResponse {
    private int id;
}
