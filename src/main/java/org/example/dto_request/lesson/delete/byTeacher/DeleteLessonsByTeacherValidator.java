package org.example.dto_request.lesson.delete.byTeacher;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteLessonsByTeacherValidator implements RequestValidator<DeleteLessonsByTeacherRequest> {
    @Override
    public List<String> validate(DeleteLessonsByTeacherRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getTeacherId(), errors, "teacherId");
        return errors;
    }
}
