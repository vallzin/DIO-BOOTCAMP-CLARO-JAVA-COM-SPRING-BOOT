package dio.springsecurityjwt.security;


import dio.springsecurityjwt.repository.UsuarioRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.SignatureException;
import java.util.List;
import java.util.stream.Collectors;

public class JWTFilter extends OncePerRequestFilter {

    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    @Autowired
    private final UsuarioRepository usuarioRepository;

    // Injeção de dependência do UsuarioRepository via construtor
    public JWTFilter(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String token = extractToken(request);
            if (token != null && !token.isEmpty()){

                // Parseia o token para um JWTObject
                JWTObject tokenObject = JWTCreator.parseToken(token, SecurityConfig.PREFIX, SecurityConfig.KEY);

                List<SimpleGrantedAuthority> authorities = authorities(tokenObject.getRoles());

                // Cria a autenticação com base no JWTObject
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        tokenObject.getSubject(),
                        null,
                        authorities);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            logger.error("Falha no processamento do JWT Token", e);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HEADER_AUTHORIZATION);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    private List<SimpleGrantedAuthority> authorities(List<String> roles) {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
