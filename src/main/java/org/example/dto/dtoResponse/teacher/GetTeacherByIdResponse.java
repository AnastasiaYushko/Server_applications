package org.example.dto.dtoResponse.teacher;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class GetTeacherByIdResponse {
    private String firstName;
    private String lastName;
    private String middleName;
}
