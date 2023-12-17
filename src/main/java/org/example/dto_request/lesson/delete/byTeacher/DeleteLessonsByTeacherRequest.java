package org.example.dto_request.lesson.delete.byTeacher;

import javax.validation.constraints.Positive;

public class DeleteLessonsByTeacherRequest {
    @Positive
    private int teacherId;

    public DeleteLessonsByTeacherRequest(@Positive int teacherId) {
        this.teacherId = teacherId;
    }

    public DeleteLessonsByTeacherRequest() {
        super();
    }

    public void setTeacherId(@Positive int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }
}
