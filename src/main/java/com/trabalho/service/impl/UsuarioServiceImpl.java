package com.trabalho.service.impl;

import com.trabalho.dto.UsuarioRequestDto;
import com.trabalho.exception.AuthenticationException;
import com.trabalho.exception.BusinessException;
import com.trabalho.mapper.UsuarioMapper;
import com.trabalho.model.UsuarioModel;
import com.trabalho.repository.UsuarioRepository;
import com.trabalho.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();;

    @Override
    public UsuarioModel adicionarUsuario(UsuarioRequestDto requestDto) {
        UsuarioModel model = mapper.requestToModel(requestDto);
        model.setSenha(encoder.encode(model.getSenha()));
        return repository.save(model);
    }

    @Override
    public UsuarioModel buscarUsuarioPorId(Integer id) {
        UsuarioModel model = repository.findById(id).orElseThrow(() -> new BusinessException(String.format("Usuário com id = %d não encontrado", id)));
        return model;
    }

    @Override
    public boolean logarUsuario(UsuarioRequestDto requestDto) {
        String nome =  requestDto.getUsuario();
        UsuarioModel model = repository.findByNome(nome)
                .orElseThrow(() -> new AuthenticationException(String.format("Esse usuário não existe! Registre-se antes de logar.", nome)));
        boolean senhaVerificada = encoder.matches(requestDto.getSenha(), model.getSenha());

        if(nome.equals(model.getNome()) && !senhaVerificada) throw new AuthenticationException("Usuário ou senha incorreta");

        return true;
    }
}
