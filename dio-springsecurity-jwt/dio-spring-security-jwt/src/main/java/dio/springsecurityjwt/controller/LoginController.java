package dio.springsecurityjwt.controller;

import dio.springsecurityjwt.dto.Login;
import dio.springsecurityjwt.dto.Sessao;
import dio.springsecurityjwt.model.Usuario;
import dio.springsecurityjwt.repository.UsuarioRepository;
import dio.springsecurityjwt.security.JWTCreator;
import dio.springsecurityjwt.security.JWTObject;
import dio.springsecurityjwt.security.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository repository;

//    @Autowired
//    private JwtConfig jwtConfig;

//    @Autowired
//    private JWTCreator jwtCreator;

    @Value("${security.jwt.expiration}")
    private long expiration;

    @Value("${security.jwt.prefix}")
    private String prefix;

    @Value("${security.jwt.key}")
    private String key;


    @PostMapping("/login")
    public ResponseEntity<Sessao> logar(@RequestBody Login login){
        Usuario usuario = repository.findByUsername(login.getUsername());
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + login.getUsername());
        }

        if (!encoder.matches(login.getPassword(), usuario.getPassword())) {
            throw new BadCredentialsException("Senha inválida para o login: " + login.getUsername());
        }

        Sessao sessao = new Sessao();
        sessao.setLogin(usuario.getUsername());

        JWTObject jwtObject = new JWTObject();
        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtObject.setExpiration(new Date(System.currentTimeMillis() + expiration));
        jwtObject.setRoles(usuario.getRoles());

        sessao.setToken(JWTCreator.create(prefix, key, jwtObject));

        return ResponseEntity.ok(sessao);
    }

}
