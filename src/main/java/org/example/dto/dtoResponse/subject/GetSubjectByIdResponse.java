package org.example.dto.dtoResponse.subject;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class GetSubjectByIdResponse {
    private String name;
}
