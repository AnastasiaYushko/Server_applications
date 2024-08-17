package org.example.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.enums.StatusStudent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Scope("prototype")
public class Student {
    @Positive
    private int id;
    @NotBlank
    @Size(max = 50)
    private String lastName;
    @NotBlank
    @Size(max = 50)
    private String firstName;
    @NotBlank
    @Size(max = 50)
    private String middleName;
    private StatusStudent status;
    private StudentGroup group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(middleName, student.middleName) && status == student.status && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, status, group);
    }
}
