package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.ContaCorrenteDto;
import br.com.bluesoft.alucar.controller.form.ContaCorrenteForm;
import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.repository.ContaCorrenteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;

@RestController
@RequestMapping("/contaCorrente")
public class ContaCorrenteController {

    private final ContaCorrenteRepository contaCorrenteRepository;
    private final VendedorRepository vendedorRepository;

    public ContaCorrenteController(ContaCorrenteRepository contaCorrenteRepository, VendedorRepository vendedorRepository) {
        this.contaCorrenteRepository = contaCorrenteRepository;
        this.vendedorRepository = vendedorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ContaCorrenteDto> cadastrar(@RequestBody @Validated ContaCorrenteForm form, UriComponentsBuilder uriBuilder) {
        ContaCorrente contaCorrente = form.converter(vendedorRepository);
        contaCorrenteRepository.save(contaCorrente);

        URI uri = uriBuilder.path("/contaCorrente/{id}").buildAndExpand(contaCorrente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContaCorrenteDto(contaCorrente));
    }
}