package com.trabalho.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoRequestDto {

    @NotBlank(message = "campo nome é obrigatório!")
    private String nome;
    @NotNull(message = "campo quantidade é obrigatório!")
    private Integer quantidade;
    @NotNull(message = "campo valor é obrigatório!")
    private Float valor;

    public ProdutoRequestDto() {
    }

    public ProdutoRequestDto(String nome, Integer quantidade, Float valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
