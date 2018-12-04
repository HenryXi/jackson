package com.henryxi.jackson.object2json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.henryxi.jackson.bean.User;

public class PrettyOutput {
    public static void main(String[] args) throws JsonProcessingException {
        printPretty1();
        printPretty2();
    }

    private static void printPretty1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setAge(28);
        user.setName("HenryXi");
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
    }

    private static void printPretty2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        User user = new User();
        user.setAge(28);
        user.setName("Justin");
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
    }
}
