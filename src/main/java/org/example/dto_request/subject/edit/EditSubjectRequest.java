package org.example.dto_request.subject.edit;

public class EditSubjectRequest {
    private int id;
    private String name;

    public EditSubjectRequest(int id, String name) {
        this.name = name;
    }

    public EditSubjectRequest() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
