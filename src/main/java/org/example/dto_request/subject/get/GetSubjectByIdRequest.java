package org.example.dto_request.subject.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Positive;

@Setter
@Getter
@Component
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class GetSubjectByIdRequest {
    @Positive
    private int id;
}
