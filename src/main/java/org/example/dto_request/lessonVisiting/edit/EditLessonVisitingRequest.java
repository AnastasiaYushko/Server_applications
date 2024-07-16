package org.example.dto_request.lessonVisiting.edit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@Component
public class EditLessonVisitingRequest {
    private int lessonVisitingId;
    private int lessonId;
    private ArrayList<String> listStudent;

    public EditLessonVisitingRequest(int lessonVisitingId, int lessonId, ArrayList<String> listStudent) {
        this.lessonId = lessonId;
        this.listStudent = new ArrayList<>(listStudent);
        this.lessonVisitingId = lessonVisitingId;
    }

    public EditLessonVisitingRequest() {
    }
}
