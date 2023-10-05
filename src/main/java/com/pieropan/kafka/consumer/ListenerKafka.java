package com.pieropan.kafka.consumer;

import com.pieropan.kafka.avro.PedidoRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerKafka {

    @KafkaListener(topics = "${kafka.topic-pedido}", groupId = "group-1")
    public void listener(PedidoRecord pedidoRecord) {
        System.out.println(pedidoRecord);
    }
}