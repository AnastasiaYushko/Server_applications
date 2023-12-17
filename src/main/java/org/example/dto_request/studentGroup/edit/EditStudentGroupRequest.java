package org.example.dto_request.studentGroup.edit;

public class EditStudentGroupRequest {
    private int id;
    private String name;

    public EditStudentGroupRequest(int id,String name){
        this.id = id;
        this.name = name;
    }

    public EditStudentGroupRequest(){
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
