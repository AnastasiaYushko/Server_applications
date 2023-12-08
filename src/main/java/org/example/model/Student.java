package org.example.model;

import org.example.enums.StatusStudent;
import org.jetbrains.annotations.*;

import java.util.Objects;

public class Student {

    private int id;

    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    private String middleName;
    private StatusStudent status;
    @NotNull
    private StudentGroup group;

    public Student(int id, @NotNull String lastName, @NotNull String firstName, String middleName, StatusStudent status, @NotNull StudentGroup group){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.group = group;
        this.status = status;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setGroup(@NotNull StudentGroup group) {
        this.group = group;
    }

    public void setStatus(StatusStudent status) {
        this.status = status;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public StatusStudent getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
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
