package org.example.dto_response.lesson;

public class AddLessonResponse {
    private int id;

    public AddLessonResponse(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
