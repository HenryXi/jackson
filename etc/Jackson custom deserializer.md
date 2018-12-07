# Jackson custom deserializer
We can use `Jackson` convert between json and object. But sometimes we need custom deserializer for special json. Let's say
you need to handle the json like following.
```json
{
	"name": "henryxi",
	"age": 30,
	"address": "Beijing,Los Angeles"
}
```
There are two addresses in `address` node. We can custom deserializer to convert this json to the object like following.
```java
public class User {
    public User(String name, int age, List<Address> address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private String name;
    private int age;
    private List<Address> address;

    //getter and setter
}
```
The complete code is here.
```java
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


// you need to add this annotation to tell Jackson to use this deserializer
@JsonDeserialize(using = CustomDeserializer.class)
public class User {
    public User(String name, int age, List<Address> address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private String name;
    private int age;
    private List<Address> address;
    //getter, setter and toString method
}

public class Address {
    private String value;
    //getter, setter and toString method
}

public class ConverterClient {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"name\": \"henryxi\", \"age\": 30, \"address\": \"Beijing,Los Angeles\" } ";
        User user = objectMapper.readValue(json, User.class);
        System.out.println(user);
    }
}
```
The output is here.
```
User{name='henryxi', age=30, address=[Address{value='Beijing'}, Address{value='Los Angeles'}]}
```

**SUMMARY**

For most json we can defined beans and use `Jackson` to deserialize them. If you want deserialize them in custom way you
can use `@JsonDeserialize` to specify a custom deserializer. You need extends `StdDeserializer` class and implement `deserialize`
method.

EOF