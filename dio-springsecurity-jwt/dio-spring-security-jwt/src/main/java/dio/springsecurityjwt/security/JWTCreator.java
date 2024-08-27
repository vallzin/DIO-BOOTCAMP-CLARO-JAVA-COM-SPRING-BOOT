package dio.springsecurityjwt.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;


//    public static final String HEADER_AUTHORIZATION = "Authorization";
//    public static final String ROLES_AUTHORITIES = "authorities";

//    public static String create(String prefix, String secretKey, JWTObject jwtObject) {

//        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
//
//        // Verifique se jwtObject e suas propriedades não são nulas
//        if (jwtObject == null || jwtObject.getRoles() == null) {
//            throw new IllegalArgumentException("JWTObject ou suas propriedades não podem ser nulas");
//        }
//
//        String token = Jwts.builder()
//            .setSubject(jwtObject.getSubject())
//            .setIssuedAt(jwtObject.getIssuedAt())
//            .setExpiration(jwtObject.getExpiration())
//            .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles()))
//            .signWith(key)
//            .compact();
//
//        return prefix + " " + token;}
//
//
//
//    public static JWTObject create(String token, String prefix, String secretKey)
//        throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
//
//        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
//
//        JWTObject object = new JWTObject();
//        token = token.replace(prefix, "").trim();
//
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        object.setSubject(claims.getSubject());
//        object.setExpiration(claims.getExpiration());
//        object.setIssuedAt(claims.getIssuedAt());
//        object.setRoles((List<String>) claims.get(ROLES_AUTHORITIES));
//
//        return object;
//    }
//
//    private static List<String> checkRoles(List<String> roles){
//        return roles.stream()
//                .map(s -> "ROLE_" + s.replaceAll("ROLE_", ""))
//                .distinct() // Adicionado para remover duplicatas
//                .collect(Collectors.toList());
//    }

@Component
public class JWTCreator {
        public static final String ROLES_AUTHORITIES = "authorities";

        public static String create(String prefix, String secretKey, JWTObject jwtObject){

            String token;

            validateParameters(secretKey, jwtObject);

            Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

            Claims claims = Jwts.claims()
                    .setSubject(jwtObject.getSubject())
                    .setIssuedAt(jwtObject.getIssuedAt())
                    .setExpiration(jwtObject.getExpiration());
            claims.put(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles()));

            token = Jwts.builder()
                    .setClaims(claims)
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

            return prefix + " " + token;
        }

        public static JWTObject parseToken (String token, String prefix, String secretKey){
            validateParameters(secretKey, token);

            Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replace(prefix, "").trim())
                    .getBody();

            JWTObject jwtObject = new JWTObject();
            jwtObject.setSubject(claims.getSubject());
            jwtObject.setExpiration(claims.getExpiration());
            jwtObject.setIssuedAt(claims.getIssuedAt());
            jwtObject.setRoles((List<String>) claims.get(ROLES_AUTHORITIES));

            return jwtObject;
        }

        private static void validateParameters (String secretKey, Object...objects){
            if (secretKey == null || secretKey.isEmpty()) {
                throw new IllegalArgumentException("O secretKey não pode ser vazio ou nulo.");
            }
            for (Object obj : objects) {
                if (obj == null) {
                    throw new IllegalArgumentException("Parâmetros não podem ser nulos.");
                }
            }
        }

        private static List<String> checkRoles (List < String > roles) {
            if (roles == null) {
                throw new IllegalArgumentException("A lista de roles não pode ser nula.");
            }
            return roles.stream()
                    .map(s -> "ROLE_" + s.replaceAll("ROLE_", ""))
                    .distinct()
                    .collect(Collectors.toList());
        }
}

