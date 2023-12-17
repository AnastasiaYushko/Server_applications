package org.example.dto_response.subject;

public class GetSubjectByIdResponse {
    private String name;

    public GetSubjectByIdResponse(String name) {
        this.name = name;
    }

    public GetSubjectByIdResponse() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
