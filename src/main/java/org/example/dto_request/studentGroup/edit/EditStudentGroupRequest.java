package org.example.dto_request.studentGroup.edit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
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
