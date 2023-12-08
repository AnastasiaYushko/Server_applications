package org.example.dto_request.subject.add;

public class AddSubjectRequest {
    private String name;

    public AddSubjectRequest(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
