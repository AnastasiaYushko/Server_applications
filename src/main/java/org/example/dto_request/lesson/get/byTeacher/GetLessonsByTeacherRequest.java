package org.example.dto_request.lesson.get.byTeacher;

public class GetLessonsByTeacherRequest {
    private String startDate;
    private String endDate;
    private int teacherId;

    public GetLessonsByTeacherRequest(String startDate, String endDate, int teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public GetLessonsByTeacherRequest() {
        super();
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }
}
