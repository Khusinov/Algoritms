import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    private int postId;
    private int id ;
    private String name ;
    private String email ;
    private String body ;

}
