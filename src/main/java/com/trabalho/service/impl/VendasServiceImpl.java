package com.trabalho.service.impl;

import com.trabalho.dto.VendasRequestDto;
import com.trabalho.mapper.VendasMapper;
import com.trabalho.model.VendasModel;
import com.trabalho.repository.VendasRepository;
import com.trabalho.service.ProdutoService;
import com.trabalho.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendasServiceImpl implements VendasService {

    @Autowired
    private VendasRepository repository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VendasMapper mapper;

    @Override
    public VendasModel addVenda(VendasRequestDto vendasRequestDto) {
        produtoService.diminuirQntEstoqueProduto(vendasRequestDto.getProdutoId(), 1);
        return repository.save(mapper.requestToModel(vendasRequestDto));
    }

    @Override
    public Double buscarTotalVendas() {
        List<VendasModel> vendas = repository.findAll();
        Double totalVendas = vendas.stream()
                .mapToDouble(v -> v.getValor())
                .sum();

        return totalVendas;
    }
}
