package org.example.dto_request.studentGroup.add;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class AddStudentGroupRequest {
    private String name;

    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public AddStudentGroupRequest() {
    }
}
