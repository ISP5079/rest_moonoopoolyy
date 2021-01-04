package israel.sandoval.rest_moonoopoolyy.controllers;

import israel.sandoval.rest_moonoopoolyy.entitys.response.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @PostMapping("hello")
    public Response helloWorld() {
        Response rp = new Response();
        rp.setMessage("Hola mundo");
        return rp;
    }
}
