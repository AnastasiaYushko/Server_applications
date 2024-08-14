package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.StatusStudent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component
@Scope("prototype")
public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private StatusStudent status;
    private StudentGroup group;

    public Student(int id, String lastName, String firstName, String middleName, StatusStudent status, StudentGroup group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.group = group;
        this.status = status;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", status=" + status +
                ", group=" + group +
                '}';
    }

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
