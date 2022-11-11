package com.trabalho.mapper;

import com.trabalho.dto.VendasRequestDto;
import com.trabalho.model.ProdutoModel;
import com.trabalho.model.UsuarioModel;
import com.trabalho.model.VendasModel;
import com.trabalho.service.ProdutoService;
import com.trabalho.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendasMapper {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProdutoService produtoService;

    public VendasModel requestToModel(VendasRequestDto requestDto) {
        VendasModel vendasModel = new VendasModel();
        vendasModel.setValor(requestDto.getValor());

        UsuarioModel usuario = usuarioService.buscarUsuarioPorId(requestDto.getUsuarioId());
        vendasModel.setUsuario(usuario);

        ProdutoModel produtoModel = produtoService.buscarProdutoPorId(requestDto.getProdutoId());
        vendasModel.setProduto(produtoModel);

        return vendasModel;
    }
}
