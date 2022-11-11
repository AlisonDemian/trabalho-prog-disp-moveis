package com.trabalho.service;

import com.trabalho.dto.VendasRequestDto;
import com.trabalho.model.VendasModel;

import java.math.BigDecimal;

public interface VendasService {

    VendasModel addVenda(VendasRequestDto vendasRequestDto);

    Double buscarTotalVendas();
}
