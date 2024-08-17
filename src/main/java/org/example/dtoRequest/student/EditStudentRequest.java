package org.example.dtoRequest.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
public class EditStudentRequest {
    @Positive
    private int id;
    @NotBlank
    @Length(max = 50)
    private String lastName;
    @NotBlank
    @Length(max = 50)
    private String firstName;
    @NotBlank
    @Length(max = 50)
    private String middleName;
    @NotBlank
    private String status;
    @Positive
    private int groupId;
}
