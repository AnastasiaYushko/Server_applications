package org.example.dto.dtoRequest.student;

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
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class DeleteStudentRequest {
    @Positive
    private int studentId;
}