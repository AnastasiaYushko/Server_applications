package org.example.network_operations;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseEntity<T> {
    private T responseData;
    private int responseStatus;

    public ResponseEntity(T responseData, int responseStatus) {
        this.responseData = responseData;
        this.responseStatus = responseStatus;
    }

    public ResponseEntity() {}

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "responseData=" + responseData +
                ", responseStatus=" + responseStatus +
                '}';
    }
}

