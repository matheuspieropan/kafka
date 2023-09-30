package com.pieropan.kafka.service;

import com.pieropan.kafka.dto.PedidoDTO;
import com.pieropan.kafka.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public void save(PedidoDTO pedido) {

    }
}