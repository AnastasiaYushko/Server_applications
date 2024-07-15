package org.example.dto_request.subject.add;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class AddSubjectRequest {
    private String name;

    public AddSubjectRequest(String name) {
        this.name = name;
    }

    public AddSubjectRequest() {
        super();
    }

}
