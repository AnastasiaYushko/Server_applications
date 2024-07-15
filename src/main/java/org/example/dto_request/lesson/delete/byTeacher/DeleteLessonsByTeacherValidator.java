package org.example.dto_request.lesson.delete.byTeacher;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteLessonsByTeacherValidator implements RequestValidator<DeleteLessonsByTeacherRequest> {

    @Override
    public List<String> validate(DeleteLessonsByTeacherRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getTeacherId(), errors, "teacherId");
        return errors;
    }
}
