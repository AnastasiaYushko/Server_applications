package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component("studentGroup")
public class StudentGroup {
    private int id;
    private String name;

    public StudentGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentGroup() {
    }

    @Override
    public String toString() {
        return "GroupOfStudents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
