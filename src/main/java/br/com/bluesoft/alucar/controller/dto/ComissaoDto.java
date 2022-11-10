package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Comissao;
import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ComissaoDto {

    private Long id;
    private BigDecimal valor;
    private Vendedor vendedor;
    private ContaCorrente contaCorrente;

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public ComissaoDto(Comissao comissao) {
        this.id = comissao.getId();
        this.valor = comissao.getValor();
        this.vendedor = comissao.getVendedor();
        this.contaCorrente = comissao.getContaCorrente();
    }

    public static List<ComissaoDto> converter(List<Comissao> comissoes) {
        return comissoes.stream().map(ComissaoDto::new).collect(Collectors.toList());
    }
}