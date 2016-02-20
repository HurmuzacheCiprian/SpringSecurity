package hc.spring.security.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by cipriach on 20.02.2016.
 */
@Builder
@Getter
@Setter
public class LoginResponse {
    private int statusCode;
    private String message;
}
