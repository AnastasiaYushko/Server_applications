package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.StatusStudent;

import java.util.Objects;

@Getter
@Setter
public class Student {

    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private StatusStudent status;
    private StudentGroup group;

    public Student(int id, String lastName, String firstName, String middleName,  StatusStudent status,  StudentGroup group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.group = group;
        this.status = status;
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
        if (!(o instanceof Student student)) return false;
        return getId() == student.getId() && getLastName().equals(student.getLastName()) && getFirstName().equals(student.getFirstName()) && Objects.equals(getMiddleName(), student.getMiddleName()) && getStatus() == student.getStatus() && getGroup().equals(student.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLastName(), getFirstName(), getMiddleName(), getStatus(), getGroup());
    }
}
