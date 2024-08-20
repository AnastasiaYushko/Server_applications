package org.example;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseEntity<T> {
    private T responseData;
    private HttpStatus responseStatus;
}

