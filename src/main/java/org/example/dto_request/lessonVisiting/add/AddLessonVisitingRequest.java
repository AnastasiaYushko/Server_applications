package org.example.dto_request.lessonVisiting.add;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Positive;
import java.util.ArrayList;

@Getter
@Setter
@Component
public class AddLessonVisitingRequest {
    private int lessonId;
    private ArrayList<String> listStudent;

    public AddLessonVisitingRequest(int lessonId, ArrayList<String> listStudent) {
        this.lessonId = lessonId;
        this.listStudent = new ArrayList<>(listStudent);
    }

    public AddLessonVisitingRequest() {
        super();
    }
}
