package dio.springsecurityjwt.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

//    @CollectionTable(name = "tab_usuario_roles", joinColumns = @JoinColumn(name = "Usuario"))
//    @Column(name = "role_id")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_usuario_roles", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "role_name")
    private List<String> roles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
