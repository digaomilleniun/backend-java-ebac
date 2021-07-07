package br.com.rpires.ebac.Springbootjsp.controller;

import br.com.rpires.ebac.Springbootjsp.domain.Usuario;
import br.com.rpires.ebac.Springbootjsp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rodrigo.pires
 */
@Controller
@SessionAttributes("name")
@RequestMapping(value="/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value="/lista-usuarios")
    public String listar(ModelMap model) {
        model.put("todos", usuarioService.listarUsuarios());
        return "/usuario/lista-usuarios";
    }

    @GetMapping(value="/novo")
    public String redirectForm() {
        return "/usuario/cadastrar";
    }

    @PostMapping(value="/salvar")
    public String salvar(ModelMap model, @ModelAttribute("Usuario") Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:lista-usuarios";
    }
}
