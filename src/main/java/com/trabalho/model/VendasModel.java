package com.trabalho.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "vendas")
@Entity
public class VendasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProdutoModel produto;

    @ManyToOne(fetch = FetchType.LAZY)
    private UsuarioModel usuario;

    private Double valor;

    public VendasModel(){}

    public VendasModel(Integer id, ProdutoModel produto, UsuarioModel usuario, Double valor) {
        this.id = id;
        this.produto = produto;
        this.usuario = usuario;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
