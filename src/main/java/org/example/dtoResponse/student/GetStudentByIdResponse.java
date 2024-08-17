package org.example.dtoResponse.student;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class GetStudentByIdResponse {
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private String group;
}
