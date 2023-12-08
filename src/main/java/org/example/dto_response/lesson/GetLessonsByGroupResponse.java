package org.example.dto_response.lesson;

import java.util.ArrayList;

public class GetLessonsByGroupResponse {
    private ArrayList<String> listLessons;

    public GetLessonsByGroupResponse(ArrayList<String> listLessons){
        this.listLessons = new ArrayList<>(listLessons);
    }

    public ArrayList<String> getListLessons() {
        return listLessons;
    }

    public void setListLessons(ArrayList<String> listLessons) {
        this.listLessons = new ArrayList<>(listLessons);
    }
}
