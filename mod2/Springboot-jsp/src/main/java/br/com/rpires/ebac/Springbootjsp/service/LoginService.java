package br.com.rpires.ebac.Springbootjsp.service;

import org.springframework.stereotype.Service;

/**
 * @author Steve.Vaz
 */
@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {
        // in28minutes, dummy
        return userid.equalsIgnoreCase("teste")
                && password.equalsIgnoreCase("teste");
    }
}
