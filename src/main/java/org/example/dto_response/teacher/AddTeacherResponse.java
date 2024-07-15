package org.example.dto_response.teacher;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class AddTeacherResponse {
    private int id;

    public AddTeacherResponse(int id) {
        this.id = id;
    }

    public AddTeacherResponse() {
        super();
    }

}
