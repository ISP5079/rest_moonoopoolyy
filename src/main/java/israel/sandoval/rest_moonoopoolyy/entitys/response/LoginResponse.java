package israel.sandoval.rest_moonoopoolyy.entitys.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse extends Response {
    private String token;
}
