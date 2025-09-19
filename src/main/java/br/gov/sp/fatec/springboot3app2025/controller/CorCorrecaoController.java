package br.gov.sp.fatec.springboot3app2025.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.gov.sp.fatec.springboot3app2025.entity.CorCorrecao;
import br.gov.sp.fatec.springboot3app2025.service.CorCorrecaoService;

@RestController
@RequestMapping("/correcao")
public class CorCorrecaoController {

    private CorCorrecaoService service;

    public CorCorrecaoController(CorCorrecaoService service) {
        this.service = service;
    }

    // rota para cadastrar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CorCorrecao novaCorrecao(@RequestBody CorCorrecao correcao) {
        return service.nova(correcao);
    }

    // rota para listar todas
    @GetMapping
    public List<CorCorrecao> buscarTodas() {
        return service.buscarTodas();
    }

    // rota para buscar por id
    @GetMapping("/{id}")
    public CorCorrecao buscarPorId(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }
}
