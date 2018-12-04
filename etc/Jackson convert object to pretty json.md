# Jackson convert object to pretty json
We use Jackson convert object to json string. If you do not add any configuration the string is plain-text without formatted.
There are 2 ways to make the json pretty when using Jackson convert object to json.

**Use writerWithDefaultPrettyPrinter**

```java
private static void printPretty1() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    User user = new User();
    user.setAge(28);
    user.setName("HenryXi");
    System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
}
```
The output like following.
```json
{
  "name" : "HenryXi",
  "age" : 28
}
```

**Use `SerializationFeature.INDENT_OUTPUT`**
```java
private static void printPretty2() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    User user = new User();
    user.setAge(28);
    user.setName("Justin");
    System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
}
```
The output like following.
```json
{
  "name" : "Justin",
  "age" : 28
}
```
