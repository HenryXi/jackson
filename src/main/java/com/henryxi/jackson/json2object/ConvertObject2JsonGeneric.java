package com.henryxi.jackson.json2object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henryxi.jackson.bean.OtherUser;
import com.henryxi.jackson.bean.User;
import com.henryxi.jackson.bean.WrapUser;

import java.util.ArrayList;
import java.util.List;

public class ConvertObject2JsonGeneric {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setName("HenryXi");
        user.setAge(29);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        WrapUser<User> wrapUser = new WrapUser<>();
        wrapUser.setName("wrap user");
        wrapUser.setUsers(userList);


        OtherUser otherUser = new OtherUser();
        otherUser.setName("HenryXi");
        otherUser.setAddress("Beijing");
        List<OtherUser> otherUserList = new ArrayList<>();
        otherUserList.add(otherUser);
        WrapUser<OtherUser> wrapOtherUser = new WrapUser<>();
        wrapOtherUser.setName("wrap user");
        wrapOtherUser.setUsers(otherUserList);
        System.out.println(objectMapper.writeValueAsString(wrapUser));
        System.out.println(objectMapper.writeValueAsString(wrapOtherUser));
    }
}
