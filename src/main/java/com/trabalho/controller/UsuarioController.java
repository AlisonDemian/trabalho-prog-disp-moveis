package com.trabalho.controller;

import com.trabalho.dto.UsuarioRequestDto;
import com.trabalho.model.UsuarioModel;
import com.trabalho.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioModel> criarUsuario(@Valid @RequestBody UsuarioRequestDto model) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.adicionarUsuario(model));
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> loginUsuario(@RequestBody UsuarioRequestDto model) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.logarUsuario(model));
    }
}
