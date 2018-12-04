package com.henryxi.jackson.json2object;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henryxi.jackson.bean.Box;
import com.henryxi.jackson.bean.User;

import java.io.IOException;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userJsonStr = "{\"name\": \"Henry\",\"age\": 28}";
        User user = objectMapper.readValue(userJsonStr, User.class);
        System.out.println("json: " + userJsonStr);
        System.out.println(user);

        String boxJsonStr = "{\"name\":\"String box\",\"value\":\"this is string\"}";
        Box stringBox = objectMapper.readValue(boxJsonStr, new TypeReference<Box<String>>() {
        });
        System.out.println("json: " + stringBox);
        System.out.println(stringBox);

        String mapJson = "{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}";
        Map<String, String> stringStringMap = objectMapper.readValue(mapJson, new TypeReference<Map<String, String>>() {
        });
        System.out.println("json: " + mapJson);
        System.out.println(stringStringMap);

        String nestMapJson = "{\"nestKey1\":{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"},\"nestKey2\":{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"},\"nestKey3\":{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}}";
        Map<String, Map<String, String>> nestMap = objectMapper.readValue(nestMapJson, new TypeReference<Map<String, Map<String, String>>>() {
        });
        System.out.println("json: " + nestMapJson);
        System.out.println(nestMap);
    }
}
