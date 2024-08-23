package org.example.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.SpringConfig;
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
        return id == student.id && Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(middleName, student.middleName) && status == student.status && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, status, group);
    }

    public boolean equalsWithoutId(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(middleName, student.middleName) && status == student.status && Objects.equals(group, student.group);
    }

    public static Student parseInStudent(String input) {
        // Массивы для хранения результатов
        String[] studentData = new String[5];
        String[] groupData = new String[2];

        // Извлечение данных о студенте
        studentData[0] = extractValue(input, "Student(id=", ",");
        studentData[1] = extractValue(input, "lastName=", ",");
        studentData[2] = extractValue(input, "firstName=", ",");
        studentData[3] = extractValue(input, "middleName=", ",");
        studentData[4] = extractValue(input, "status=", ",");

        // Извлечение данных о группе
        groupData[0] = extractValue(input, "group=StudentGroup(id=", ",");
        groupData[1] = extractValue(input, "name=", "))");

        StudentGroup studentGroup = SpringConfig.getContext().getBean("studentGroup", StudentGroup.class);
        studentGroup.setId(Integer.parseInt(groupData[0]));
        studentGroup.setName(groupData[1]);

        Student student = SpringConfig.getContext().getBean("student", Student.class);
        student.setId(Integer.parseInt(studentData[0]));
        student.setFirstName(studentData[2]);
        student.setStatus(StatusStudent.valueOf(studentData[4]));
        student.setLastName(studentData[1]);
        student.setMiddleName(studentData[3]);
        student.setGroup(studentGroup);

        return student;
    }

    private static String extractValue(String input, String prefix, String suffix) {
        int startIndex = input.indexOf(prefix);

        // Проверка на наличие префикса
        if (startIndex == -1) {
            throw new IllegalArgumentException("Ошибка в переданный строке");
        }

        startIndex += prefix.length();
        int endIndex = input.indexOf(suffix, startIndex);

        // Проверка на наличие суффикса
        if (endIndex == -1) {
            throw new IllegalArgumentException("Ошибка в переданный строке");
        }

        return input.substring(startIndex, endIndex).trim();
    }
}
