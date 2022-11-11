package com.trabalho.mapper;

import com.trabalho.dto.ProdutoRequestDto;
import com.trabalho.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoModel requestToModel(ProdutoRequestDto requestDto) {
        ProdutoModel model = new ProdutoModel();
        model.setNome(requestDto.getNome());
        model.setQuantidade(requestDto.getQuantidade());
        model.setValor(requestDto.getValor());
        return model;
    }
}
