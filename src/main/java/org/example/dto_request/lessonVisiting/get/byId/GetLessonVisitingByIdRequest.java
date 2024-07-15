package org.example.dto_request.lessonVisiting.get.byId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class GetLessonVisitingByIdRequest {
    private int lessonVisitingId;

    public GetLessonVisitingByIdRequest(int lessonVisitingId) {
        this.lessonVisitingId = lessonVisitingId;
    }

    public GetLessonVisitingByIdRequest() {
        super();
    }

}
