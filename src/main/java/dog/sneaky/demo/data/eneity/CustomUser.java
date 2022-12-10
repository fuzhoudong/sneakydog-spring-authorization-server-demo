package dog.sneaky.demo.data.eneity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dog.sneaky.demo.data.Identifier;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@Table("users")
public class CustomUser extends Identifier<Long> {
    private String username;

    @JsonIgnore
    private transient String password;
    private String enabled;

    private String email;
    private Integer age;
}


