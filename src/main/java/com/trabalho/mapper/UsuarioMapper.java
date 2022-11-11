package com.trabalho.mapper;

import com.trabalho.dto.UsuarioRequestDto;
import com.trabalho.model.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel requestToModel(UsuarioRequestDto requestDto) {
        UsuarioModel model = new UsuarioModel();
        model.setNome(requestDto.getUsuario());
        model.setSenha(requestDto.getSenha());
        return model;
    }
}
