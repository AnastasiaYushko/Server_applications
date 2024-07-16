package org.example.dto_request.lesson.delete.byGroup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class DeleteLessonsByGroupRequest {
    private int groupId;

    public DeleteLessonsByGroupRequest(int groupId) {
        this.groupId = groupId;
    }

    public DeleteLessonsByGroupRequest() {
    }
}
