package org.example.dtoResponse.lesson;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
@Data
public class GetLessonsByGroupResponse {
    private ArrayList<String> listLessons;
}
