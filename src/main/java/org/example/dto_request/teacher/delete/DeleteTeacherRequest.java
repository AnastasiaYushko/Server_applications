package org.example.dto_request.teacher.delete;

public class DeleteTeacherRequest {
    private int id;

    public DeleteTeacherRequest(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
