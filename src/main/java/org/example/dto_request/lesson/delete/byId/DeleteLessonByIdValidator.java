package org.example.dto_request.lesson.delete.byId;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteLessonByIdValidator implements RequestValidator<DeleteLessonByIdRequest> {

    @Override
    public List<String> validate(DeleteLessonByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}
