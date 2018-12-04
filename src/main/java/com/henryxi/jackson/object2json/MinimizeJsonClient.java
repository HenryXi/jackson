package com.henryxi.jackson.object2json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henryxi.jackson.bean.User;

public class MinimizeJsonClient {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setAge(30);
        user.setName("HenryXi");
        System.out.println(objectMapper.writeValueAsString(user));
    }
}
