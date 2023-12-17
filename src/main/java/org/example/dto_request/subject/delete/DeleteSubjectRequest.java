package org.example.dto_request.subject.delete;

public class DeleteSubjectRequest {
    private int id;

    public DeleteSubjectRequest(int id) {
        this.id = id;
    }

    public DeleteSubjectRequest() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
