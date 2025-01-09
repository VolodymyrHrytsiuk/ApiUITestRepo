package firstTaskAPI.pojo.requests;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
}
