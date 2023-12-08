package org.example.validators;

import java.util.List;

public interface RequestValidator<T> {
    List<String> validate(T request, List<String> error);
}
