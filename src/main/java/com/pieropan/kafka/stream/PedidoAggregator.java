package com.pieropan.kafka.stream;

import com.pieropan.kafka.dto.PedidoDTO;
import com.pieropan.kafka.serdes.PedidoSerdes;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PedidoAggregator {

    @Value("${kafka.topic-pedido}")
    private String kafkaTopic;

    private final String MSG = "Pedido recebido de: ";

    @Bean
    public void aggregador(StreamsBuilder streamsBuilder) {
        streamsBuilder
                .stream("pix-topic-2", criarConsumed())
                .groupBy((key, value) -> value.getValor());
//                .aggregate(
//                        () -> 0.0,
//                        (key, value, aggregate) -> (aggregate + value.getValor()),
//                        Materialized.with(Serdes.String(), Serdes.Double())
//                );
    }

    private Consumed<String, PedidoDTO> criarConsumed() {
        return Consumed.with(Serdes.String(), PedidoSerdes.serdes());
    }
}