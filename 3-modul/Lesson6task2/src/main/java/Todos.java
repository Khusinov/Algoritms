import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Todos {
    private int userId ;
    private int id ;
    private String title  ;
    private boolean completed ;

}
