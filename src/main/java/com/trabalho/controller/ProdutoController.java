package com.trabalho.controller;

import com.trabalho.dto.ProdutoRequestDto;
import com.trabalho.model.ProdutoModel;
import com.trabalho.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/produto")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@Valid @RequestBody ProdutoRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addProduto(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarProdutos());
    }

    @PutMapping("/{id}/preco")
    public ResponseEntity<ProdutoModel> atualizarPrecoProduto(Integer id, Float novoValor) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.atualizarPreco(id, novoValor));
    }

    @PutMapping("/{id}/estoque")
    public ResponseEntity<List<ProdutoModel>> atualizarEstoqueProduto(Integer id, Integer qntRetirada) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarProdutos());
    }
}
