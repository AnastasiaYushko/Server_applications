package org.example.dto_request.student.get.byId;

public class GetStudentByIdRequest {
    private int studentId;

    public GetStudentByIdRequest(int studentId){
        this.studentId = studentId;
    }

    public void setId(int studentId) {
        this.studentId = studentId;
    }

    public int getId() {
        return studentId;
    }
}
