package org.example.dto_request.studentGroup.delete;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class DeleteStudentGroupRequest {
    private int id;

    public DeleteStudentGroupRequest(int id) {
        this.id = id;
    }

    public DeleteStudentGroupRequest() {
    }
}
