package hc.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cipriach on 20.02.2016.
 */
@Service
public class TokenGenerator {
    private static final Logger logger = LoggerFactory.getLogger(TokenGenerator.class);

    private final static HttpSessionCsrfTokenRepository tokenRepository = new HttpSessionCsrfTokenRepository();

    public CsrfToken generateToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        CsrfToken generatedToken = tokenRepository.generateToken(httpServletRequest);
        logger.info("Generated token with value {}", generatedToken.getToken());
        tokenRepository.saveToken(generatedToken, httpServletRequest, httpServletResponse);
        return generatedToken;
    }

    public HttpSessionCsrfTokenRepository getTokenRepository() {
        return tokenRepository;
    }
}
