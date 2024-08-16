package org.example.dto_response.teacher;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
@Scope("prototype")
public class GetTeachersResponse {
    private ArrayList<String> listTeachers;
}
