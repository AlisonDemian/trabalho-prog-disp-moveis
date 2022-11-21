package com.trabalho.service;

import com.trabalho.dto.UsuarioRequestDto;
import com.trabalho.model.UsuarioModel;

public interface UsuarioService {

    UsuarioModel adicionarUsuario(UsuarioRequestDto requestDto);

    UsuarioModel buscarUsuarioPorId(Integer id);
    Integer logarUsuario(UsuarioRequestDto requestDto);
}
