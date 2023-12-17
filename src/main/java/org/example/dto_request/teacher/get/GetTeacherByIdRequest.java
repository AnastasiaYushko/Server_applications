package org.example.dto_request.teacher.get;

public class GetTeacherByIdRequest {
    private int id;

    public GetTeacherByIdRequest(int id) {
        this.id = id;
    }

    public GetTeacherByIdRequest() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
