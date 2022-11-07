package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;
import com.sun.istack.NotNull;

import java.time.LocalDate;

public class ClienteForm {
    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Long cpf;
    @NotNull
    private String email;
    @NotNull
    private Long celular;


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Long getCelular() {
        return celular;
    }

    public Cliente converter() {
        return new Cliente(nome, cpf, email, celular);
    }
}