package org.example.dto_request.subject.edit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class EditSubjectRequest {
    private int id;
    private String name;

    public EditSubjectRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EditSubjectRequest() {
    }
}
