package com.pieropan.kafka.consumer;

import com.pieropan.kafka.dto.PedidoDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerKafka {

    @KafkaListener(topics = "pedido-topic", groupId = "group-1")
    public void listener(PedidoDTO pedido) {
        System.out.println(pedido);
    }
}