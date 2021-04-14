import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Posts {
    private Integer userId ;
    private Integer id ;
    private String title ;
    private String body ;
}
