package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.CarroDto;
import br.com.bluesoft.alucar.controller.dto.ComissaoDto;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Comissao;
import br.com.bluesoft.alucar.repository.ComissaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comissoes")
public class ComissaoController {

    private final ComissaoRepository comissaoRepository;

    public ComissaoController(ComissaoRepository comissaoRepository) {
        this.comissaoRepository = comissaoRepository;
    }

    @GetMapping
    public List<ComissaoDto> lista() {
        List<Comissao> comissoes = comissaoRepository.findAll();
        return ComissaoDto.converter(comissoes);
    }

    @GetMapping("{id}")
    public ComissaoDto detalhar(@PathVariable Long id) {
        Comissao comissao = comissaoRepository.getReferenceById(id);
        return new ComissaoDto(comissao);
    }
}