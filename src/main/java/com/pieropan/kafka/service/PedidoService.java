package com.pieropan.kafka.service;

import com.pieropan.kafka.avro.PedidoRecord;
import com.pieropan.kafka.dto.PedidoDTO;
import com.pieropan.kafka.dto.PedidoResponseDTO;
import com.pieropan.kafka.entity.Pedido;
import com.pieropan.kafka.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.pieropan.kafka.mapper.PedidoMapper.INSTANCE;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private KafkaTemplate<String, PedidoRecord> kafkaTemplate;

    @Value("${kafka.topic-pedido}")
    private String kafkaTopic;

    public PedidoResponseDTO save(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRepository.save(INSTANCE.toPedido(pedidoDTO));
        kafkaTemplate.send(kafkaTopic, criarPedidoRecord(pedidoDTO));

        return INSTANCE.toPedidoDto(pedido);
    }

    PedidoRecord criarPedidoRecord(PedidoDTO pedidoDTO) {
        return PedidoRecord.newBuilder()
                .setNome(pedidoDTO.getNome())
                .setNumero(pedidoDTO.getNumero())
                .setValor(pedidoDTO.getValor())
                .build();
    }
}