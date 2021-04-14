import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String name ;
    private String surname ;
    private  String fatherName ;
    private String tumani ;
    private Integer numberPassport ; // pasport raqami
    private Integer inn ;
    private boolean type ;  //erkak = true ; ayol = false ;
    private String dateBirth ; // tugulgan sana
    private String Malumoti ;
    private boolean married ; // turmush qurgan=true ; else false ;

    public User setInn(Integer inn) {
        this.inn = inn;
        return null;
    }
}
