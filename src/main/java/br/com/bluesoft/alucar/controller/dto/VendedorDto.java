package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Vendedor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class VendedorDto {
    private Long id;

    private String nome;

    private Long cpf;

    private LocalDate dataAdmissao;

    public VendedorDto(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        this.cpf = vendedor.getCpf();
        this.dataAdmissao = vendedor.getDataAdmissao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public static List<VendedorDto> converter(List<Vendedor> vendedores) {
        return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
    }
}