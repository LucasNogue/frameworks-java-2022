package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.repository.CarroRepository;
import com.sun.istack.NotNull;

import java.math.BigDecimal;

public class AtualizacaoCarroForm {
    @NotNull
    private String marca;
    @NotNull
    private String modelo;
    @NotNull
    private String cor;
    @NotNull
    private Integer ano;
    @NotNull
    private Integer quilometragem;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }


    public Carro atualizar(String placa , CarroRepository carroRepository) {
        Carro carro = carroRepository.getReferenceById(placa);

        carro.setMarca(this.marca);
        carro.setModelo(this.modelo);
        carro.setCor(this.cor);
        carro.setAno(this.ano);
        carro.setQuilometragem(this.quilometragem);

        return carro;
    }
}
