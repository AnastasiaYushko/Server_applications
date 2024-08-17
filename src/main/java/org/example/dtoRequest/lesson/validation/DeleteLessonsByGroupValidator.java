package org.example.dtoRequest.lesson.validation;

import org.example.dtoRequest.lesson.DeleteLessonsByGroupRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteLessonsByGroupValidator implements RequestValidator<DeleteLessonsByGroupRequest> {

    @Override
    public List<String> validate(DeleteLessonsByGroupRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getGroupId(), errors, "groupId");
        return errors;
    }
}
