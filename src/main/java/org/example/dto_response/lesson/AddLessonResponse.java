package org.example.dto_response.lesson;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
public class AddLessonResponse {
    private int id;
}
