package org.example.dto_request.student.edit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class EditStudentRequest {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private String group;

    public EditStudentRequest(int id, String lastName, String firstName, String middleName, String status, String groupId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.group = groupId;
    }

    public EditStudentRequest() {
        super();
    }

}
