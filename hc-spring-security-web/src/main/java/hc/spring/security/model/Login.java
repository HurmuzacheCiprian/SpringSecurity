package hc.spring.security.model;

import lombok.*;

/**
 * Created by cipriach on 20.02.2016.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    private String userName;
    private String password;
}
