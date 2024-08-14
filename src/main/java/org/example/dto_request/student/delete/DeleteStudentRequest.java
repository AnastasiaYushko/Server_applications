package org.example.dto_request.student.delete;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class DeleteStudentRequest {
    private int studentId;

    public DeleteStudentRequest(int studentId) {
        this.studentId = studentId;
    }

    public DeleteStudentRequest() {
    }
}
