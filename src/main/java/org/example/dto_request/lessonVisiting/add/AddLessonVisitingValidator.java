package org.example.dto_request.lessonVisiting.add;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddLessonVisitingValidator implements RequestValidator<AddLessonVisitingRequest> {
    @Override
    public List<String> validate(AddLessonVisitingRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}
