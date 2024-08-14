package org.example.dto_request.lessonVisiting.add;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@Component
@Scope("prototype")
public class AddLessonVisitingRequest {
    private int lessonId;
    private ArrayList<String> listStudent;

    public AddLessonVisitingRequest(int lessonId, ArrayList<String> listStudent) {
        this.lessonId = lessonId;
        this.listStudent = new ArrayList<>(listStudent);
    }

    public AddLessonVisitingRequest() {
    }
}
