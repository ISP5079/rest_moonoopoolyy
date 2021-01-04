package israel.sandoval.rest_moonoopoolyy.services.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import israel.sandoval.rest_moonoopoolyy.entitys.request.LoginRequest;
import israel.sandoval.rest_moonoopoolyy.entitys.response.LoginResponse;
import israel.sandoval.rest_moonoopoolyy.services.LoginService;
import israel.sandoval.rest_moonoopoolyy.utils.Constantes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${jwt.secret.key}")
    public String secretKey;
    @Value("${jwt.secret.key}")
    public String id;

    @Override
    public LoginResponse getJWTToken(LoginRequest loginRequest) {

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId(id)
                .setSubject(loginRequest.getUsername())
                .claim(Constantes.JWT_AUTHORITIES,
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Constantes.EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        LoginResponse response = new LoginResponse();
        response.setCode(200);
        response.setToken(Constantes.JWT_PREFIX + token);
        response.setMessage("Login exitoso");
        return response;
    }
}
