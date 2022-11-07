package br.com.bluesoft.alucar.controller.dto;

import br.com.bluesoft.alucar.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;


public class ClienteDto {

    private Long id;
    private String nome;
    private Long cpf;
    private String email;
    private Long celular;

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
    }

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

    public static List<ClienteDto> converter(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }
}
