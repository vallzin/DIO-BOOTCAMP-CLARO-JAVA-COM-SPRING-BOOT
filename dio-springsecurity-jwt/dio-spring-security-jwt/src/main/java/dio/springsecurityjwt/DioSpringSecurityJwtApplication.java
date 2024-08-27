package dio.springsecurityjwt;

import dio.springsecurityjwt.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "dio.springsecurityjwt")
@EnableConfigurationProperties(SecurityConfig.class)
public class DioSpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioSpringSecurityJwtApplication.class, args);
	}

}
