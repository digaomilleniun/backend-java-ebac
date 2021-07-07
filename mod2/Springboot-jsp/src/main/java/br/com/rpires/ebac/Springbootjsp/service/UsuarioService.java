package br.com.rpires.ebac.Springbootjsp.service;

import br.com.rpires.ebac.Springbootjsp.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rodrigo.pires
 */
@Service
public class UsuarioService {

    private Map<String, Usuario> map = new HashMap<>();

    public List<Usuario> listarUsuarios() {
        return map.values().stream().collect(Collectors.toList());
    }

    public void salvar(Usuario usuario) {
        this.map.put(usuario.getEmail(), usuario);
    }
}
