package org.example.dto_request.studentGroup.delete;

public class DeleteStudentGroupRequest {
    private int id;

    public DeleteStudentGroupRequest(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
