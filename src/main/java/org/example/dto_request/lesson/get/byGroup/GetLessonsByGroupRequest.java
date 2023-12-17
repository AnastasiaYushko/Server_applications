package org.example.dto_request.lesson.get.byGroup;

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
        super();
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }
}
