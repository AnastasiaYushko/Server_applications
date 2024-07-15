package org.example.dto_request.teacher.get;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class GetTeacherByIdRequest {
    private int id;

    public GetTeacherByIdRequest(int id) {
        this.id = id;
    }

    public GetTeacherByIdRequest() {
        super();
    }

}
