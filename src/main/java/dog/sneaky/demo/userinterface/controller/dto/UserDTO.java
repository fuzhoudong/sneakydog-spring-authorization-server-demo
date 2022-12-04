package dog.sneaky.demo.userinterface.controller.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserDTO extends DTO{
    private String username;
    private String sex;
    private int age;
    private String email;


}
