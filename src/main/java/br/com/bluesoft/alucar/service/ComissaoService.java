package br.com.bluesoft.alucar.service;

import br.com.bluesoft.alucar.model.Comissao;
import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;
import br.com.bluesoft.alucar.repository.ComissaoRepository;
import br.com.bluesoft.alucar.repository.ContaCorrenteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ComissaoService {

    private final ContaCorrenteRepository contaCorrenteRepository;
    private final ComissaoRepository comissaoRepository;

    public ComissaoService(ContaCorrenteRepository contaCorrenteRepository, ComissaoRepository comissaoRepository) {
        this.contaCorrenteRepository = contaCorrenteRepository;
        this.comissaoRepository = comissaoRepository;
    }

    public void cadastrarComissao(Vendedor vendedor, BigDecimal valorTotal) {

        Optional<ContaCorrente> contaCorrenteOptional = contaCorrenteRepository.encontraContaCorrenteDoVendedor(vendedor.getId());
        if(contaCorrenteOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        ContaCorrente contaCorrente = contaCorrenteOptional.get();

        Period tempoDoVendedorNaEsmpresa = Period.between(vendedor.getDataAdmissao(), LocalDate.now());
        int anosDoVendedorNaEmpresa = tempoDoVendedorNaEsmpresa.getYears();

        BigDecimal valorDaComissao;

        if(anosDoVendedorNaEmpresa >= 5){
            valorDaComissao = valorTotal.multiply(BigDecimal.valueOf(0.13));
        }
        else {
            valorDaComissao = valorTotal.multiply(BigDecimal.valueOf(0.1));
        }

        Comissao comissao = new Comissao();
        comissao.setValor(valorDaComissao);
        comissao.setVendedor(vendedor);
        comissao.setContaCorrente(contaCorrente);

        comissaoRepository.save(comissao);
    }
}