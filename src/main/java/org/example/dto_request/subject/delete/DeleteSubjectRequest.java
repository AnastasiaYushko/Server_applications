package org.example.dto_request.subject.delete;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class DeleteSubjectRequest {
    private int id;

    public DeleteSubjectRequest(int id) {
        this.id = id;
    }

    public DeleteSubjectRequest() {
        super();
    }

}
