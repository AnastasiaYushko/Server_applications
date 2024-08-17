package org.example.dto_request.lesson;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class GetLessonsByGroupRequest {
    @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))")
    private String startDate;
    @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))")
    private String endDate;
    @Positive
    private int groupId;
}
