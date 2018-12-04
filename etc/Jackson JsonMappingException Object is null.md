# Jackson JsonMappingException: Object is null
When I try to convert `net.sf.json.JSONObject` to json I got the `JsonMappingException`. After checking the stack 
information I know I forget init the value of user. The detail of exception is like following.
```
Exception in thread "main" com.fasterxml.com.henryxi.jackson.databind.JsonMappingException: Object is null (through reference chain: net.sf.json.JSONObject["group"]->net.sf.json.JSONObject["user"]->net.sf.json.JSONNull["empty"])
	at com.fasterxml.com.henryxi.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:388)
	at com.fasterxml.com.henryxi.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:348)
	at com.fasterxml.com.henryxi.jackson.databind.ser.std.StdSerializer.wrapAndThrow(StdSerializer.java:343)
	at com.fasterxml.com.henryxi.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:698)
	at com.fasterxml.com.henryxi.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:155)
	at com.fasterxml.com.henryxi.jackson.databind.ser.std.MapSerializer.serializeFields(MapSerializer.java:633)
	at com.fasterxml.com.henryxi.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:536)
	at com.fasterxml.com.henryxi.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:30)
	at com.fasterxml.com.henryxi.jackson.databind.ser.std.MapSerializer.serializeFields(MapSerializer.java:633)
	at com.fasterxml.com.henryxi.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:536)
	at com.fasterxml.com.henryxi.jackson.databind.ser.std.MapSerializer.serialize(MapSerializer.java:30)
	at com.fasterxml.com.henryxi.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:292)
	at com.fasterxml.com.henryxi.jackson.databind.ObjectMapper._configAndWriteValue(ObjectMapper.java:3681)
	at com.fasterxml.com.henryxi.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3057)
	at com.henryxi.com.henryxi.jackson.object2json.TestJSONObject.main(TestJSONObject.java:16)
```
The code is like following.
```java
public class Group {
    private String groupName;
    private User user;

    //getter and setter methods
}

public class User {
    private String name;
    private int age;

    //getter and setter methods
}


public class TestJSONObject {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonObject = new JSONObject();
        Group group = new Group();
        group.setGroupName("test name");
        //group.setUser(new User()); after initing the user the exception is missing
        jsonObject.put("group", group);
        System.out.println(objectMapper.writeValueAsString(jsonObject));
    }
}
```
I strongly recommend you don't use `net.sf.json.JSONObject` as the wrapper class when you want to convert object to json.
You can define you own wrapper class and convert it to json like following.
```java
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

class WrapperGroup{
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
```
The output is like following.
```
{"group":{"groupName":"test name","user":{"name":null,"age":0}}}
```