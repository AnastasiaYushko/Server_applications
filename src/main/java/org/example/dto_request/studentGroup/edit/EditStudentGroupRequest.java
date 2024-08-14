package org.example.dto_request.studentGroup.edit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class EditStudentGroupRequest {
    private int id;
    private String name;

    public EditStudentGroupRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EditStudentGroupRequest() {
    }
}