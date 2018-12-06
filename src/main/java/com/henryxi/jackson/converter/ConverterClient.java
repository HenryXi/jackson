package com.henryxi.jackson.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConverterClient {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"name\": \"henryxi\", \"age\": 30, \"address\": \"Beijing,Los Angeles\" } ";
        User user = objectMapper.readValue(json, User.class);
        System.out.println(user);
    }
}
