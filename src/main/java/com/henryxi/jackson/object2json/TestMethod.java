package com.henryxi.jackson.object2json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henryxi.jackson.bean.Address;

public class TestMethod {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Address address = new Address();
        System.out.println(objectMapper.writeValueAsString(address));
    }
}
