package org.example.dto_request.teacher.delete;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class DeleteTeacherRequest {
    private int id;

    public DeleteTeacherRequest(int id) {
        this.id = id;
    }

    public DeleteTeacherRequest() {
    }
}
