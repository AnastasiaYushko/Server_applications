package org.example.dto_request.student.get.byGroup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class GetStudentsByGroupRequest {
    private int groupId;

    public GetStudentsByGroupRequest(int groupId) {
        this.groupId = groupId;
    }

    public GetStudentsByGroupRequest() {
        super();
    }

}
