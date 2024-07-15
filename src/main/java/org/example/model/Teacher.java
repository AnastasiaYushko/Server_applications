package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
public class Teacher {
    private int id = 0;
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";

    public Teacher(int id,String firstName, String middleName,  String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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
        if (!(o instanceof Teacher teacher)) return false;
        return getId() == teacher.getId() && getFirstName().equals(teacher.getFirstName()) && Objects.equals(getMiddleName(), teacher.getMiddleName()) && getLastName().equals(teacher.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getMiddleName(), getLastName());
    }
}
