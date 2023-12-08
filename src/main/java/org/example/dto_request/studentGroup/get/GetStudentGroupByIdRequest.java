package org.example.dto_request.studentGroup.get;

public class GetStudentGroupByIdRequest {
    private int id;

    public GetStudentGroupByIdRequest(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
