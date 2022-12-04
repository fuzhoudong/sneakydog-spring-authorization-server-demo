package dog.sneaky.demo.userinterface.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorityController {
    @GetMapping("myAuthority.html")
    public String myAuthority(){
        return "myAuthority";
    }
}
