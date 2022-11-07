package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.ClienteRepository;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import com.sun.istack.NotNull;

public class AtualizacaoClienteForm {

    @NotNull
    private String nome;
    @NotNull
    private Long cpf;
    @NotNull
    private String email;
    @NotNull
    private Long celular;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public Cliente atualizar(Long id , ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.getReferenceById(id);

        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setEmail(this.email);
        cliente.setCelular(this.celular);
        return cliente;
    }
}
