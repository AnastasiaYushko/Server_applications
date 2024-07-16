package org.example.dto_response.subject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Setter
@Getter
@Component
public class GetSubjectsResponse {
    private ArrayList<String> listSubjects;

    public GetSubjectsResponse(ArrayList<String> listSubjects) {
        this.listSubjects = new ArrayList<>(listSubjects);
    }

    public GetSubjectsResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetSubjectsResponse that = (GetSubjectsResponse) o;
        return Objects.equals(listSubjects, that.listSubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(listSubjects);
    }
}
