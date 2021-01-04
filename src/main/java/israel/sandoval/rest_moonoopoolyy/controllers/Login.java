package israel.sandoval.rest_moonoopoolyy.controllers;

import israel.sandoval.rest_moonoopoolyy.entitys.request.LoginRequest;
import israel.sandoval.rest_moonoopoolyy.entitys.response.LoginResponse;
import israel.sandoval.rest_moonoopoolyy.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    @Autowired
    private LoginService service;

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return service.getJWTToken(loginRequest);
    }
}
