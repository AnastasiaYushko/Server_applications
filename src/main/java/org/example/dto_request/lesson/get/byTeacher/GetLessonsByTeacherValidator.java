package org.example.dto_request.lesson.get.byTeacher;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorDate;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetLessonsByTeacherValidator implements RequestValidator<GetLessonsByTeacherRequest> {
    @Override
    public List<String> validate(GetLessonsByTeacherRequest request,List<String> errors) {

        ValidatorNumber.validateNumber(request.getTeacherId(),errors,"teacherId");

        ValidatorDate.validateDate(request.getStartDate(),errors,"startDate");

        ValidatorDate.validateDate(request.getEndDate(),errors,"endDate");

        return errors;
    }
}