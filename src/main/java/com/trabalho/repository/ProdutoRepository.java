package com.trabalho.repository;

import com.trabalho.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {

    Optional<ProdutoModel> findByNome(String nome);
}
