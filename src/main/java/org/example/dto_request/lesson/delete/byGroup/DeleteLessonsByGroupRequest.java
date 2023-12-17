package org.example.dto_request.lesson.delete.byGroup;

public class DeleteLessonsByGroupRequest {
    private int groupId;

    public DeleteLessonsByGroupRequest(int groupId){
        this.groupId = groupId;
    }

    public DeleteLessonsByGroupRequest(){
        super();
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }
}
