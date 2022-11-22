package com.trabalho.service.impl;

import com.trabalho.dto.ProdutoRequestDto;
import com.trabalho.exception.BusinessException;
import com.trabalho.mapper.ProdutoMapper;
import com.trabalho.model.ProdutoModel;
import com.trabalho.repository.ProdutoRepository;
import com.trabalho.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper mapper;

    @Override
    public ProdutoModel addProduto(ProdutoRequestDto requestDto) {
        ProdutoModel novoProd = mapper.requestToModel(requestDto);
        repository.findByNome(novoProd.getNome()).ifPresentOrElse( m -> {
            novoProd.setId(m.getId());
            novoProd.setQuantidade(novoProd.getQuantidade() + m.getQuantidade());
        }, null);
        return repository.save(novoProd);
    }

    @Override
    public ProdutoModel buscarProdutoPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Produto não encontrado"));
    }

    @Override
    public List<ProdutoModel> listarProdutos() {
        return repository.findAll();
    }

    @Override
    public ProdutoModel atualizarPreco(Integer id, Float novoPreco) {
        ProdutoModel model = buscarProdutoPorId(id);
        model.setValor(novoPreco);

        return repository.save(model);
    }

    @Override
    public void diminuirQntEstoqueProduto(Integer id, Integer qnt) {
        ProdutoModel model = buscarProdutoPorId(id);
        Integer qntAtual = model.getQuantidade();

        if(qntAtual < qnt) throw new BusinessException("Quantidade em estoque insuficiente para compra");

        model.setQuantidade(Math.subtractExact(qntAtual, qnt));
        repository.save(model);
    }
}
