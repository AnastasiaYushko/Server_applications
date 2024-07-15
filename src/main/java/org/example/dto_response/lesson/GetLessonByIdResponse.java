package org.example.dto_response.lesson;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component
public class GetLessonByIdResponse {
    private String date;
    private int number;
    private int teacherId;
    private int groupId;

    public GetLessonByIdResponse(String date, int number, int teacherId, int groupId) {
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public GetLessonByIdResponse() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetLessonByIdResponse that)) return false;
        return getNumber() == that.getNumber() && getTeacherId() == that.getTeacherId() && groupId == that.groupId && getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getNumber(), getTeacherId(), groupId);
    }
}
