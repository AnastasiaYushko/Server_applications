package org.example.dto_request.subject.get;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class GetSubjectByIdRequest {
    private int id;

    public GetSubjectByIdRequest(int id) {
        this.id = id;
    }

    public GetSubjectByIdRequest() {
    }
}
