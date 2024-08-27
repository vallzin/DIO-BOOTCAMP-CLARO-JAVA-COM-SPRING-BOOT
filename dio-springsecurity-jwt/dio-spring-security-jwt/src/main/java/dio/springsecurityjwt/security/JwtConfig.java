package dio.springsecurityjwt.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class JwtConfig {

    @Value("${security.jwt.key}")
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }
}
