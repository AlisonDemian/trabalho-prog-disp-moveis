package com.trabalho.repository;

import com.trabalho.model.VendasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<VendasModel, Integer> {
}
