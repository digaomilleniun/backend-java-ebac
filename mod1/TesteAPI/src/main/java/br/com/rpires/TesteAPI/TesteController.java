package br.com.rpires.TesteAPI;


import java.io.IOException;
import java.net.http.HttpResponse;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Steve.Vaz
 */
@RestController
@RequestMapping(value = "/api/v1/teste")
public class TesteController {

    @GetMapping(value = "/teste1")
    public ResponseEntity<String> teste1() {
        return ResponseEntity.ok("Teste");
    }

    @GetMapping(value = "/api/v1/teste/teste2")
    @ResponseBody
    public String teste2(HttpResponse<?> response) throws IOException {
        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("    <body>");
        html.append("        <h1>Olá </h1>");
        html.append("    </body>");
        html.append("</html>");
        return html.toString();
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
