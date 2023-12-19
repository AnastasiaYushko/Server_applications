package org.example.handler;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.ParseException;

public interface IHandler {
    String handler(String str) throws JsonProcessingException, ParseException;
}
