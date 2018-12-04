package com.henryxi.jackson.object2json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henryxi.jackson.bean.Group;
import com.henryxi.jackson.bean.User;
import com.henryxi.jackson.bean.WrapperGroup;

public class TestJSONObject {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Group group = new Group();
        group.setGroupName("test name");
        group.setUser(new User());
        WrapperGroup wrapperGroup = new WrapperGroup();
        wrapperGroup.setGroup(group);
        System.out.println(objectMapper.writeValueAsString(wrapperGroup));
    }
}
