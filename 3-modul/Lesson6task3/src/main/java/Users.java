import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone ;
    private String website ;
    private Company company;
}
