package org.example.dto_request.student.delete;

public class DeleteStudentRequest {
    private int studentId;

    public DeleteStudentRequest(int studentId) {
        this.studentId = studentId;
    }

    public DeleteStudentRequest() {
        super();
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
}
