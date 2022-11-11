package com.trabalho.controller;

import com.trabalho.dto.VendasRequestDto;
import com.trabalho.model.VendasModel;
import com.trabalho.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/venda")
@RestController
public class VendaController {

    @Autowired
    private VendasService service;

    @PostMapping
    public ResponseEntity<VendasModel> addCompra(@Valid @RequestBody VendasRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addVenda(requestDto));
    }

    @GetMapping
    public ResponseEntity<Double> buscarTotalVendas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.buscarTotalVendas());
    }
}
