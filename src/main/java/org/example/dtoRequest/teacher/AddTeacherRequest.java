package org.example.dtoRequest.teacher;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class AddTeacherRequest {
    @NotBlank
    @Length(max = 50)
    private String lastName;
    @NotBlank
    @Length(max = 50)
    private String firstName;
    @NotBlank
    @Length(max = 50)
    private String middleName;
}
