package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.AluguelDto;
import br.com.bluesoft.alucar.controller.form.AluguelForm;
import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.repository.AluguelRepository;
import br.com.bluesoft.alucar.repository.CarroRepository;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import br.com.bluesoft.alucar.service.ComissaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelRepository aluguelRepository;
    private final VendedorRepository vendedorRepository;
    private final ClienteRepository clienteRepository;
    private final CarroRepository carroRepository;
    private final ComissaoService comissaoService;


    public AluguelController(AluguelRepository aluguelRepository, VendedorRepository vendedorRepository, ClienteRepository clienteRepository,
                             CarroRepository carroRepository, ComissaoService comissaoService) {
        this.aluguelRepository = aluguelRepository;
        this.vendedorRepository = vendedorRepository;
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
        this.comissaoService = comissaoService;
    }

    @GetMapping
    public List<AluguelDto> lista() {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        return AluguelDto.converter(alugueis);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AluguelDto> cadastrar(@RequestBody @Validated AluguelForm form, UriComponentsBuilder uriBuilder) {

        Aluguel aluguel = form.converter(vendedorRepository, clienteRepository, carroRepository);
        aluguelRepository.save(aluguel);

        BigDecimal  valorTotal = aluguel.getValor().multiply(BigDecimal.valueOf(aluguel.getDias()));


        comissaoService.cadastrarComissao(aluguel.getVendedor(),valorTotal);
        //vendedor conta valorTotal

        URI uri = uriBuilder.path("/alugueis/{id}").buildAndExpand(aluguel.getId()).toUri();
        return ResponseEntity.created(uri).body(new AluguelDto(aluguel));
    }

}