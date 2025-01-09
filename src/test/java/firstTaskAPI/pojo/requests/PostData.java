package firstTaskAPI.pojo.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostData {
    private String title;
    private String body;
    private int userId;
}
