package br.com.bluesoft.alucar.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ContaCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_corrente_key")
    private Long id;
    @NotNull
    private String banco;
    @NotNull
    private Integer agencia;
    @NotNull
    private Integer contaCorrente;
    @NotNull
    @OneToOne
    @JoinColumn(name = "vendedor_key")
    private Vendedor vendedor;

    public ContaCorrente(String banco, Integer agencia, Integer contaCorrente, Vendedor vendedor) {
        this.banco = banco;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.vendedor = vendedor;
    }
    public ContaCorrente() {}

    public Long getId() {
        return id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Integer contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
