package br.com.bluesoft.alucar.controller.form;

import br.com.bluesoft.alucar.model.Carro;
import com.sun.istack.NotNull;

import java.math.BigDecimal;


public class CarroForm {

    @NotNull
    private String placa;
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
    @NotNull
    private BigDecimal diaria;

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public BigDecimal getDiaria() {
        return diaria;
    }

    public Carro converter() {
        return new Carro(placa, marca, modelo,
                cor, ano,
                quilometragem, diaria);
    }
}
