package hc.spring.security.resource;

import hc.spring.security.TokenGenerator;
import hc.spring.security.model.Login;
import hc.spring.security.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cipriach on 20.02.2016.
 */
@RestController
public class LoginResource {

    @Autowired
    private TokenGenerator tokenGenerator;

    @RequestMapping(path = "/login/custom", method = RequestMethod.POST)
    public LoginResponse validateLogin(@RequestBody Login login) {
        return LoginResponse.builder().message("Authenticated").statusCode(200).build();
    }

    @RequestMapping(path = "/customToken", method = RequestMethod.GET, produces = "application/json")
    public CsrfToken getToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return tokenGenerator.generateToken(httpServletRequest, httpServletResponse);
    }

}
