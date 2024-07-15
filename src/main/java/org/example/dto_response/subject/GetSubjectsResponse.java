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
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetSubjectsResponse that)) return false;
        return Objects.equals(getListSubjects(), that.getListSubjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListSubjects());
    }
}
