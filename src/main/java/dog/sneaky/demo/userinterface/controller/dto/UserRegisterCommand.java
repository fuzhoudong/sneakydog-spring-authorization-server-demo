package dog.sneaky.demo.userinterface.controller.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRegisterCommand {
    private String username;
    private RegisterDTO registerDTO;
}
