package org.example.dto.dtoResponse.studentGroup;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
@Scope("prototype")
public class GetStudentGroupsResponse {
    private ArrayList<String> groups;
}
