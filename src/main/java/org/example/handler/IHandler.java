package org.example.handler;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IHandler {
    String handler(String str) throws JsonProcessingException;
}
