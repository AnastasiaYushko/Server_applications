package org.example.dto_request.lesson.delete.byGroup;

import javax.validation.constraints.Positive;

public class DeleteLessonsByGroupRequest {
    @Positive
    private int groupId;

    public DeleteLessonsByGroupRequest(@Positive int groupId){
        this.groupId = groupId;
    }

    public void setGroupId( @Positive int groupId) {
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }
}
