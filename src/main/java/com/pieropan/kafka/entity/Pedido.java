package com.pieropan.kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pedido {

    @Id
    private Long id;
}