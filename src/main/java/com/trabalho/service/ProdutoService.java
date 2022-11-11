package com.trabalho.service;

import com.trabalho.dto.ProdutoRequestDto;
import com.trabalho.model.ProdutoModel;

import java.util.List;

public interface ProdutoService {

    ProdutoModel addProduto(ProdutoRequestDto requestDto);

    ProdutoModel buscarProdutoPorId(Integer id);

    List<ProdutoModel> listarProdutos();

    ProdutoModel atualizarPreco(Integer id, Float novoPreco);

    void diminuirQntEstoqueProduto(Integer id, Integer qnt);



}
