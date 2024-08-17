package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ResponseEntity<T> {
    private T responseData;
    private HttpStatus responseStatus;

    public ResponseEntity(T responseData, HttpStatus responseStatus) {
        this.responseData = responseData;
        this.responseStatus = responseStatus;
    }

    public ResponseEntity() {
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "responseData=" + responseData +
                ", responseStatus=" + responseStatus +
                '}';
    }
}

