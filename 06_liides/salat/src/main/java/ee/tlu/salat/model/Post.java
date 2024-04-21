package ee.tlu.salat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
// json to pojo --> https://json2csharp.com/code-converters/json-to-pojo
public class Post {

    // https://jsonplaceholder.typicode.com/posts
    // sama mis lehel (userId, id, title, body)
    private int userId;
    private int id;
    private String title;
    private String body;

}
