package org.example.dto_response.subject;

public class EditSubjectResponse {
    private String name;

    public EditSubjectResponse(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
