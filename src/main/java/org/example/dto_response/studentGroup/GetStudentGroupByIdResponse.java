package org.example.dto_response.studentGroup;

public class GetStudentGroupByIdResponse {
    private String name;

    public GetStudentGroupByIdResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
