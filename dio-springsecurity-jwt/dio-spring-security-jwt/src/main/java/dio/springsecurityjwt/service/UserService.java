package dio.springsecurityjwt.service;

import dio.springsecurityjwt.model.Usuario;
import dio.springsecurityjwt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void createUsuario(Usuario usuario) {
        // Codifica a senha do usuário antes de salvar
        String pass = usuario.getPassword();
        usuario.setPassword(encoder.encode(pass));
        usuarioRepository.save(usuario);
    }

}
