package com.pieropan.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO {

    private int numero;

    private String nome;

    private Double valor;
}