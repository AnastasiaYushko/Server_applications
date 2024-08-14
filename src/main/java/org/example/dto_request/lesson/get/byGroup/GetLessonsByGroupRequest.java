package org.example.dto_request.lesson.get.byGroup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class GetLessonsByGroupRequest {
    private String startDate;
    private String endDate;
    private int groupId;

    public GetLessonsByGroupRequest(String startDate, String endDate, int groupId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
    }

    public GetLessonsByGroupRequest() {
    }
}
