package org.example.dto_response.subject;

public class AddSubjectResponse {
    private int id;

    public AddSubjectResponse(int id) {
        this.id = id;
    }

    public AddSubjectResponse() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
