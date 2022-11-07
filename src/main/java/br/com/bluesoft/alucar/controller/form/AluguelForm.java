package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.CarroRepository;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import com.sun.istack.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class AluguelForm {
    @NotNull
    private Long id;
    @NotNull
    private Integer dias;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private LocalDate data;
    @NotNull
    private Long vendedor;
    @NotNull
    private Long cliente;
    @NotNull
    private String carro;

    public Long getId() {
        return id;
    }

    public Integer getDias() {
        return dias;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Long getVendedor() {
        return vendedor;
    }

    public Long getCliente() {
        return cliente;
    }

    public String getCarro() {
        return carro;
    }

    public Aluguel converter(VendedorRepository vendedorRepository, ClienteRepository clienteRepository, CarroRepository carroRepository) {
        Optional<Cliente> clienteAluguel = clienteRepository.findById(cliente);
        Optional<Vendedor> vendedorAluguel = vendedorRepository.findById(vendedor);
        Optional<Carro> carroAluguel = carroRepository.findById(carro);

        return new Aluguel(dias, valor, data,
                vendedorAluguel.get(),clienteAluguel.get(), carroAluguel.get());
    }
}