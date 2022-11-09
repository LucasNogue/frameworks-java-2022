package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;
import com.sun.istack.NotNull;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.stream.Collectors;

public class ContaCorrenteDto {

    private String banco;
    private Integer agencia;
    private Integer contaCorrente;
    private Vendedor vendedor;

    public ContaCorrenteDto(ContaCorrente contaCorrente) {
        this.banco = contaCorrente.getBanco();
        this.agencia = contaCorrente.getAgencia();
        this.contaCorrente = contaCorrente.getContaCorrente();
        this.vendedor = contaCorrente.getVendedor();
    }

    public String getBanco() {
        return banco;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public static List<ContaCorrenteDto> converter(List<ContaCorrente> contasCorrentes) {
        return contasCorrentes.stream().map(ContaCorrenteDto::new).collect(Collectors.toList());
    }
}