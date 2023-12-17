package org.example.dto_response.teacher;

public class AddTeacherResponse {
    private int id;

    public AddTeacherResponse(int id) {
        this.id = id;
    }

    public AddTeacherResponse() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
