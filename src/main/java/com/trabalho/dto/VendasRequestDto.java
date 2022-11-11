package com.trabalho.dto;

import javax.validation.constraints.NotNull;

public class VendasRequestDto {

    @NotNull(message = "campo produtoId é obrigatório!")
    private Integer produtoId;
    @NotNull(message = "campo usuarioId é obrigatório!")
    private Integer usuarioId;
    @NotNull(message = "campo valor é obrigatório!")
    private Double valor;

    public VendasRequestDto() {
    }

    public VendasRequestDto(Integer produtoId, Integer usuarioId, Double valor) {
        this.produtoId = produtoId;
        this.usuarioId = usuarioId;
        this.valor = valor;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
