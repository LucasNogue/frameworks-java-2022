package br.com.bluesoft.alucar.controller;

import br.com.bluesoft.alucar.controller.dto.VendedorDto;
import br.com.bluesoft.alucar.controller.form.AtualizacaoVendedorForm;
import br.com.bluesoft.alucar.controller.form.VendedorForm;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    private final VendedorRepository vendedorRepository;

    public VendedorController(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @GetMapping
    public List<VendedorDto> lista() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        return VendedorDto.converter(vendedores);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VendedorDto> cadastrar(@RequestBody @Validated VendedorForm form, UriComponentsBuilder uriBuilder) {
        Vendedor vendedor = form.converter();
        vendedorRepository.save(vendedor);

        URI uri = uriBuilder.path("/vendedores/{id}").buildAndExpand(vendedor.getId()).toUri();
        return ResponseEntity.created(uri).body(new VendedorDto(vendedor));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VendedorDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoVendedorForm form) {
        Optional<Vendedor> optional = vendedorRepository.findById(id);
        if(optional.isPresent()) {
            Vendedor vendedor = form.atualizar(id, vendedorRepository);
            return ResponseEntity.ok(new VendedorDto(vendedor));
        }
        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Vendedor> optional = vendedorRepository.findById(id);
        if(optional.isPresent()) {
            vendedorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
