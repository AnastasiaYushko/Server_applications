package org.example.dto_request.lesson.delete.byTeacher;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class DeleteLessonsByTeacherRequest {
    private int teacherId;

    public DeleteLessonsByTeacherRequest(int teacherId) {
        this.teacherId = teacherId;
    }

    public DeleteLessonsByTeacherRequest() {
    }
}
