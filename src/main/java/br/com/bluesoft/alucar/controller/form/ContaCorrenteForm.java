package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.VendedorRepository;
import com.sun.istack.NotNull;

import java.util.Optional;

public class ContaCorrenteForm {
    @NotNull
    private String banco;
    @NotNull
    private Integer agencia;
    @NotNull
    private Integer contaCorrente;
    @NotNull
    private String vendedor;

    public String getBanco() {
        return banco;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public ContaCorrente converter(VendedorRepository vendedorRepository) {
        Optional<Vendedor> vendedorContaCorrente = vendedorRepository.findByNome(vendedor);
        return new ContaCorrente(banco, agencia, contaCorrente,  vendedorContaCorrente.get());
    }
}