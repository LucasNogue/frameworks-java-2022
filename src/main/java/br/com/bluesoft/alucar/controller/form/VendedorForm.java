package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Vendedor;
import com.sun.istack.NotNull;

import java.time.LocalDate;

public class VendedorForm {
    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Long cpf;
    @NotNull
    private LocalDate dataAdmissao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public Vendedor converter() {
        return new Vendedor(nome, cpf, dataAdmissao);
    }
}
