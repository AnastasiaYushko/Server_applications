package org.example.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Teacher {
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String middleName;

    public Teacher(int id, @NotNull String firstName, String middleName, @NotNull String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public @NotNull String getLastName() {
        return lastName;
    }

    public @NotNull String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
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
