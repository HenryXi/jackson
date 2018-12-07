package com.henryxi.jackson.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CustomDeserializer extends StdDeserializer<User> {
    public CustomDeserializer() {
        super(User.class);
    }

    public CustomDeserializer(Class<?> vc) {
        super(vc);
    }

    public CustomDeserializer(JavaType valueType) {
        super(valueType);
    }

    public CustomDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public User deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        int age = (Integer) node.get("age").numberValue();
        String name = node.get("name").asText();
        String addressStr = node.get("address").asText();
        List<Address> addressList = new LinkedList<>();
        for (String address : addressStr.split(",")) {
            addressList.add(new Address(address));
        }
        return new User(name, age, addressList);
    }
}
