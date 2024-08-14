package org.example.dto_request.studentGroup.add;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class AddStudentGroupRequest {
    private String name;

    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public AddStudentGroupRequest() {
    }
}
