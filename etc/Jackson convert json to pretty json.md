# Jackson convert json to pretty json
I have showed you how to convert object to pretty json in my [previous blog](http://www.henryxi.com/jackson-convert-object-to-pretty-json).
Today I will how you how to convert json string to pretty json. Before using `writerWithDefaultPrettyPrinter` method 
we need to convert json string to `Object` first then convert object to pretty json.

Use Jackson to convert string json to pretty json. The pom file is like following.

**pom.xml**
```xml
<dependency>
    <groupId>com.fasterxml.com.henryxi.jackson.core</groupId>
    <artifactId>com.henryxi.jackson-databind</artifactId>
    <version>2.8.4</version>
</dependency>
<dependency>
    <groupId>net.sf.json-lib</groupId>
    <artifactId>json-lib</artifactId>
    <version>2.4</version>
</dependency>
```

**code**
```java
public class StringPrettyOutput {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = "{ \"name\" : \"HenryXi\", \"age\" : 28 }";
        Object json = objectMapper.readValue(str, Object.class);// convert json to Object 
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
    }
}
```
The output is like following
```
{
  "name" : "HenryXi",
  "age" : 28
}

```
