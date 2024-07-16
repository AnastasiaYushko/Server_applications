package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component("teacher")
public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;

    public Teacher(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(firstName, teacher.firstName) && Objects.equals(lastName, teacher.lastName) && Objects.equals(middleName, teacher.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName);
    }
}
