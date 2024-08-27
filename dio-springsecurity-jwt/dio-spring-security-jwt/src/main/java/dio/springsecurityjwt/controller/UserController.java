package dio.springsecurityjwt.controller;

import dio.springsecurityjwt.model.Usuario;
import dio.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public void postUser(@RequestBody Usuario usuario) {
        service.createUsuario(usuario);
    }
}
