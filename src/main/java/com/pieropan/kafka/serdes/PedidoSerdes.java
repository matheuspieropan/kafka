package com.pieropan.kafka.serdes;

import com.pieropan.kafka.dto.PedidoDTO;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class PedidoSerdes {

    public static Serde<PedidoDTO> serdes() {
        JsonSerializer<PedidoDTO> serializer = new JsonSerializer<>();
        JsonDeserializer<PedidoDTO> deserializer = new JsonDeserializer<>();

        return Serdes.serdeFrom(serializer, deserializer);
    }
}