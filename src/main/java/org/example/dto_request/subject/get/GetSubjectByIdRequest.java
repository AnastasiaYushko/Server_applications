package org.example.dto_request.subject.get;

public class GetSubjectByIdRequest {
    private int id;

    public GetSubjectByIdRequest(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
