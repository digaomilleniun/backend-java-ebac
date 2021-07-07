package br.com.rpires.TesteAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

/**
 * @author rodrigo.pires
 */
@RestController
@RequestMapping(value = "/api/v1/teste")
public class TesteController {

    @GetMapping(value = "/teste1")
    public ResponseEntity<String> teste1() {
        return ResponseEntity.ok("Teste");
    }

    @GetMapping(value = "/teste2")
    public void teste2(HttpServletResponse response) throws IOException {
        response.getWriter().write("<html>");
        response.getWriter().write("    <body>");
        response.getWriter().write("        <h1>Olá </h1>");
        response.getWriter().write("    </body>");
        response.getWriter().write("</html>");
    }

    @GetMapping(value = "/teste3/{nome}")
    @ResponseBody
    public String teste3(@PathVariable String nome) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("    <body>");
        sb.append("        <h1> Olá ");
        sb.append(nome);
        sb.append("        </h1>");
        sb.append("    </body>");
        sb.append("</html>");
        return sb.toString();
    }
}
