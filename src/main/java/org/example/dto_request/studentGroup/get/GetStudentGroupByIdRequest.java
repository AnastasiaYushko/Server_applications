package org.example.dto_request.studentGroup.get;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class GetStudentGroupByIdRequest {
    private int id;

    public GetStudentGroupByIdRequest(int id) {
        this.id = id;
    }

    public GetStudentGroupByIdRequest() {
    }
}
