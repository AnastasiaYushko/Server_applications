package org.example.dto_response.lesson;

import java.util.ArrayList;
import java.util.Objects;

public class GetLessonsByTeacherResponse {
    private ArrayList<String> listLessons;

    public GetLessonsByTeacherResponse(ArrayList<String> listLessons) {
        this.listLessons = new ArrayList<>(listLessons);
    }

    public GetLessonsByTeacherResponse() {
        super();
    }

    public ArrayList<String> getListLessons() {
        return listLessons;
    }

    public void setListLessons(ArrayList<String> listLessons) {
        this.listLessons = new ArrayList<>(listLessons);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonsByTeacherResponse that)) return false;
        return Objects.equals(getListLessons(), that.getListLessons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListLessons());
    }
}
