package com.henryxi.jackson.string2format_json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class StringPrettyOutput {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = "{ \"name\" : \"HenryXi\", \"age\" : 28 }";
        Object json = objectMapper.readValue(str, Object.class);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
    }
}
