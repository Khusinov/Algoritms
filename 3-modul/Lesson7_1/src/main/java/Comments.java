import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comments {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;


}
