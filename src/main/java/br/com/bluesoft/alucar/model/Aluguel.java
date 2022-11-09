package br.com.bluesoft.alucar.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluguel_key")
    private Long id;
    private String modelo;
    private Integer dias;
    private BigDecimal valor;
    @Column(name = "data_aluguel")
    private LocalDate data;
    @OneToOne
    @JoinColumn(name="vendedor_key")
    private Vendedor vendedor;
    @OneToOne
    @JoinColumn(name="cliente_key")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name="placa")
    private Carro carro;

    public Aluguel(String modelo, Integer dias, BigDecimal valor, LocalDate data, Vendedor vendedor, Cliente cliente, Carro carro) {
        this.modelo = modelo;
        this.dias = dias;
        this.valor = valor;
        this.data = data;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.carro = carro;
    }

    public Aluguel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
