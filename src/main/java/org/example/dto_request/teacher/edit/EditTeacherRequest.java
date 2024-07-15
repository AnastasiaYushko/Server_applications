package org.example.dto_request.teacher.edit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class EditTeacherRequest {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;

    public EditTeacherRequest(int id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public EditTeacherRequest() {
        super();
    }

}
