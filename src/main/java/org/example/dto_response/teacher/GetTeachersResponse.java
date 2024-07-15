package org.example.dto_response.teacher;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Setter
@Getter
@Component
public class GetTeachersResponse {
    private ArrayList<String> listTeachers;

    public GetTeachersResponse(ArrayList<String> listTeachers) {
        this.listTeachers = new ArrayList<>(listTeachers);
    }

    public GetTeachersResponse() {
        super();
    }
}
