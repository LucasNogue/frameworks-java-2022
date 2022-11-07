package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.CarroDto;
import br.com.bluesoft.alucar.controller.form.AtualizacaoCarroForm;
import br.com.bluesoft.alucar.controller.form.CarroForm;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.repository.CarroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @GetMapping
    public List<CarroDto> lista() {
        List<Carro> carros = carroRepository.findAll();
        return CarroDto.converter(carros);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CarroDto> cadastrar(@RequestBody @Validated CarroForm form, UriComponentsBuilder uriBuilder) {
        Carro carro = form.converter();
        carroRepository.save(carro);

        URI uri = uriBuilder.path("/carros/{placa}").buildAndExpand(carro.getPlaca()).toUri();
        return ResponseEntity.created(uri).body(new CarroDto(carro));
    }

    @PutMapping("/{placa}")
    @Transactional
    public ResponseEntity<CarroDto> atualizar(@PathVariable String placa, @RequestBody @Validated AtualizacaoCarroForm form) {
        Optional<Carro> optional = carroRepository.findById(placa);
        if(optional.isPresent()) {
            Carro carro = form.atualizar(placa, carroRepository);
            return ResponseEntity.ok(new CarroDto(carro));
        }
        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{placa}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable String placa) {
        Optional<Carro> optional = carroRepository.findById(placa);
        if(optional.isPresent()) {
            carroRepository.deleteById(placa);
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }
}