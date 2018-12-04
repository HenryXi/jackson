# Jackson ignore unrecognized field
You will get `UnrecognizedPropertyException` if you convert json string to object with unknown field. There are 2 ways
to avoid this problem. Use `JsonIgnoreProperties` annotation or add `DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES` 
to `ObjectMapper` configuration. Examples are in the following.

**Use `JsonIgnoreProperties`**
```java
public class ConvertJson2ObjectUnknownField {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userJsonStr = "{\"name\": \"Henry\",\"age\": 28,\"address\": \"Beijing\"}";
        User user = objectMapper.readValue(userJsonStr, User.class);// throw UnrecognizedPropertyException
        IgnoreFieldUser ignoreFieldUser = objectMapper.readValue(userJsonStr, IgnoreFieldUser.class);
        System.out.println(ignoreFieldUser);
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class IgnoreFieldUser {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "IgnoreFieldUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

**Use `DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES`**
```java
public class ConvertJson2ObjectUnknownField {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String userJsonStr = "{\"name\": \"Henry\",\"age\": 28,\"address\": \"Beijing\"}";
        User user = objectMapper.readValue(userJsonStr, User.class);// won't throw UnrecognizedPropertyException
        System.out.println(user);
    }
}
```