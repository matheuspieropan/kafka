package com.pieropan.kafka.controller;

import com.pieropan.kafka.dto.PedidoDTO;
import com.pieropan.kafka.dto.PedidoResponseDTO;
import com.pieropan.kafka.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> save(@RequestBody PedidoDTO pedido) {
        return ResponseEntity.ok(pedidoService.save(pedido));
    }
}