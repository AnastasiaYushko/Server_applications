package org.example.dto_request.lesson.get.byTeacher;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("prototype")
public class GetLessonsByTeacherRequest {
    private String startDate;
    private String endDate;
    private int teacherId;

    public GetLessonsByTeacherRequest(String startDate, String endDate, int teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public GetLessonsByTeacherRequest() {
    }
}
