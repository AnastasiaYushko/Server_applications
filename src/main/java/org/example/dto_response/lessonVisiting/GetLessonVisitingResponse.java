package org.example.dto_response.lessonVisiting;

import java.util.ArrayList;

public class GetLessonVisitingResponse {
    private ArrayList<String> listLessonVisiting;

    public GetLessonVisitingResponse(ArrayList<String> listLessonVisiting){
        this.listLessonVisiting = new ArrayList<>(listLessonVisiting);
    }

    public ArrayList<String> getListLessonVisiting() {
        return listLessonVisiting;
    }

    public void setListLessonVisiting(ArrayList<String> listLessonVisiting) {
        this.listLessonVisiting = new ArrayList<>(listLessonVisiting);
    }
}
