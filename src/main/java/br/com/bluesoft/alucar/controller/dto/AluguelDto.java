package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Aluguel;
import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AluguelDto {

    private Long id;
    private Integer dias;
    private BigDecimal valor;
    private LocalDate data;
    private Vendedor vendedor;
    private Cliente cliente;
    private Carro carro;


    public AluguelDto(Aluguel aluguel) {
        this.id = aluguel.getId();
        this.dias = aluguel.getDias();
        this.valor = aluguel.getValor();
        this.data = aluguel.getData();
        this.vendedor = aluguel.getVendedor();
        this.cliente = aluguel.getCliente();
        this.carro = aluguel.getCarro();
    }

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

    public Cliente getCliente() {
        return cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }


//    public static List<AluguelDto> converter(List<Carro> carros) {
//        return carros.stream().map(CarroDto::new).collect(Collectors.toList());
//    }
}
