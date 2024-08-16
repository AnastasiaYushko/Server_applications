package org.example.dto_response.studentGroup;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class GetStudentGroupByIdResponse {
    private String name;
}
