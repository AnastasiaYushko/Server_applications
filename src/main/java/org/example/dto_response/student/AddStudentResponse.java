package org.example.dto_response.student;

public class AddStudentResponse {
    private int id;

    public AddStudentResponse(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
