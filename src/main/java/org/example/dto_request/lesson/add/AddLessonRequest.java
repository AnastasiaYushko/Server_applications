package org.example.dto_request.lesson.add;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class AddLessonRequest {

    private String date;
    private int number;
    private int teacherId;
    private int groupId;
    private int subjectId;


    public AddLessonRequest(String date, int number, int teacherId, int groupId, int subjectId) {
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

    public AddLessonRequest() {
        super();
    }

}
