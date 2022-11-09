package br.com.bluesoft.alucar.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Comissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comissao_key")
    private Long id;

    private BigDecimal valor;

    @OneToOne
    @JoinColumn(name = "vendedor_key")
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "conta_corrente_key")
    private ContaCorrente contaCorrente;

    public Comissao(BigDecimal valor, Vendedor vendedor, ContaCorrente contaCorrente) {
        this.valor = valor;
        this.vendedor = vendedor;
        this.contaCorrente = contaCorrente;
    }

    public Comissao() {

    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
}
