package org.example.dto_request.student.get.byId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class GetStudentByIdRequest {
    private int studentId;

    public GetStudentByIdRequest(int studentId) {
        this.studentId = studentId;
    }

    public GetStudentByIdRequest() {

    }
}
