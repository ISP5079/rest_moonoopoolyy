package israel.sandoval.rest_moonoopoolyy.services;

import israel.sandoval.rest_moonoopoolyy.entitys.request.LoginRequest;
import israel.sandoval.rest_moonoopoolyy.entitys.response.LoginResponse;

public interface LoginService {
    LoginResponse getJWTToken(LoginRequest loginRequest);
}
