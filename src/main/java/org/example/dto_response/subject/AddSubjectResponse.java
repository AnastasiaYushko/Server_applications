package org.example.dto_response.subject;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class AddSubjectResponse {
    private int id;
}
