package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import com.sun.istack.NotNull;

import java.time.LocalDate;

public class AtualizacaoVendedorForm {

    @NotNull
    private String nome;
    @NotNull
    private Long cpf;
    @NotNull
    private LocalDate dataAdmissao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Vendedor atualizar(Long id , VendedorRepository vendedorRepository) {
        Vendedor vendedor = vendedorRepository.getReferenceById(id);

        vendedor.setNome(this.nome);
        vendedor.setCpf(this.cpf);
        vendedor.setDataAdmissao(this.dataAdmissao);
        return vendedor;
    }
}
