package org.example.dto_request.student.add;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class AddStudentRequest {
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private String groupId;

    public AddStudentRequest(String lastName, String firstName, String middleName, String status, String groupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.status = status;
        this.groupId = groupId;
    }

    public AddStudentRequest() {
        super();
    }
}
