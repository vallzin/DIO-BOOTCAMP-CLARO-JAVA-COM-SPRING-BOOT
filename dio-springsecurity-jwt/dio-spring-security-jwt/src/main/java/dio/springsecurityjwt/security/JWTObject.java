package dio.springsecurityjwt.security;

import java.util.Date;
import java.util.List;

public class JWTObject {

    private String subject;//nome usuário
    private Date issuedAt;// data criação token
    private Date expiration;// data expiração token
    private List<String> roles;// perfis de acesso

    public JWTObject() { }

    public JWTObject(List<String> roles) { this.roles = roles; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public Date getIssuedAt() { return issuedAt; }

    public void setIssuedAt(Date issuedAt) { this.issuedAt = issuedAt; }

    public Date getExpiration() { return expiration; }

    public void setExpiration(Date expiration) { this.expiration = expiration; }

    public List<String> getRoles() { return this.roles; }

    public void setRoles(List<String> roles) {  this.roles = roles;}
}
