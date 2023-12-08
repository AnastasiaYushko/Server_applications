package org.example.dto_response.lesson;

import java.util.ArrayList;

public class GetLessonsByTeacherResponse {
    private ArrayList<String> listLessons;

    public GetLessonsByTeacherResponse(ArrayList<String> listLessons){
        this.listLessons = new ArrayList<>(listLessons);
    }

    public ArrayList<String> getListLessons() {
        return listLessons;
    }

    public void setListLessons(ArrayList<String> listLessons) {
        this.listLessons = new ArrayList<>(listLessons);
    }
}
