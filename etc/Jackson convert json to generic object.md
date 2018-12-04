# Jackson convert json to generic object example
It is easy using Jackson to convert JSON string to Object. In this page I will show you how to convert JSON string to generic
object with Jackson. `TypeReference` is very useful when you convert json string to generic object (like `Map`, `List` or 
other generic object).

**convert simple object**

User class like following.
```java
public class User {
    private String name;
    private int age;

    //get and set methods

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

```java
public static void main(String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    String userJsonStr = "{\"name\": \"Henry\",\"age\": 28}";
    User user = objectMapper.readValue(userJsonStr, User.class);
    System.out.println("json: " + userJsonStr);
    System.out.println(user);
}
```
output
```
json: {"name": "Henry","age": 28}
User{name='Henry', age=28}
```
**convert generic object**

Generic object `Box<T>` like following.
```java
public class Box<T> {
    private String name;
    private T value;

    //get and set method

    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
```

```java
public static void main(String[] args) throws IOException {
    String boxJsonStr = "{\"name\":\"String box\",\"value\":\"this is string\"}";
    Box stringBox = objectMapper.readValue(boxJsonStr, new TypeReference<Box<String>>() {
    });
    System.out.println("json: " + stringBox);
    System.out.println(stringBox);
}
```
output
```
json: Box{name='String box', value=this is string}
Box{name='String box', value=this is string}
```

**convert json string to `Map`**
```java
public static void main(String[] args) throws IOException {
    String mapJson = "{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}";
    Map<String, String> stringStringMap = objectMapper.readValue(mapJson, new TypeReference<Map<String, String>>() {
    });
    System.out.println("json: " + mapJson);
    System.out.println(stringStringMap);
}
```
output
```
json: {"key1":"value1","key2":"value2","key3":"value3"}
{key1=value1, key2=value2, key3=value3}
```

**convert json string to nest `Map`**
```java
public static void main(String[] args) throws IOException {
    String nestMapJson = "{\"nestKey1\":{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"},\"nestKey2\":{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"},\"nestKey3\":{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}}";
    Map<String, Map<String, String>> nestMap = objectMapper.readValue(nestMapJson, new TypeReference<Map<String, Map<String, String>>>() {
    });
    System.out.println("json: " + nestMapJson);
    System.out.println(nestMap);
}
```
output
```
json: {"nestKey1":{"key1":"value1","key2":"value2","key3":"value3"},"nestKey2":{"key1":"value1","key2":"value2","key3":"value3"},"nestKey3":{"key1":"value1","key2":"value2","key3":"value3"}}
{nestKey1={key1=value1, key2=value2, key3=value3}, nestKey2={key1=value1, key2=value2, key3=value3}, nestKey3={key1=value1, key2=value2, key3=value3}}
```