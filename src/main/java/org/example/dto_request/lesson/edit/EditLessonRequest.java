package org.example.dto_request.lesson.edit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class EditLessonRequest {
    private int id;
    private String date;
    private int number;
    private int teacherId;
    private int groupId;
    private int subjectId;

    public EditLessonRequest(int id, String date, int number, int teacherId, int groupId,int subjectId) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

    public EditLessonRequest() {
        super();
    }

}
