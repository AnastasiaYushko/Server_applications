package org.example.dto_request.lessonVisiting.get.byILessonId;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetLessonVisitingByLessonIdValidator implements RequestValidator<GetLessonVisitingByLessonIdRequest> {
    @Override
    public List<String> validate(GetLessonVisitingByLessonIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}
