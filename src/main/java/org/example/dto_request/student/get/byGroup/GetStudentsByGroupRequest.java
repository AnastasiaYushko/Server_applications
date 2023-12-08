package org.example.dto_request.student.get.byGroup;

public class GetStudentsByGroupRequest {
    private int groupId;

    public GetStudentsByGroupRequest(int groupId){
        this.groupId = groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }
}
