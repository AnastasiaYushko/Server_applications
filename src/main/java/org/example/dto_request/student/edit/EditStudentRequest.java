package org.example.dto_request.student.edit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class EditStudentRequest {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private int groupId;

    public EditStudentRequest(int id, String lastName, String firstName, String middleName, String status, int groupId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.groupId = groupId;
    }

    public EditStudentRequest() {
    }
}
