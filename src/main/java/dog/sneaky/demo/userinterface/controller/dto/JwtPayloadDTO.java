package dog.sneaky.demo.userinterface.controller.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JwtPayloadDTO {
    private String email;
    private Long iat;
    private Long exp;
}
