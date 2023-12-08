package org.example.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Subject {
    private int id;
    @NotNull
    private String name;

    public Subject(int id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject that)) return false;
        return getId() == that.getId() && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
