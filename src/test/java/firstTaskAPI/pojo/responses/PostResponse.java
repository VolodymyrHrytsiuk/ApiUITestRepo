package firstTaskAPI.pojo.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PostResponse {
    private int userId;
    private int id;
    private String title;
    private String body;
}
