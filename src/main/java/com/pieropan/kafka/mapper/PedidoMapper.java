package com.pieropan.kafka.mapper;

import com.pieropan.kafka.dto.PedidoDTO;
import com.pieropan.kafka.dto.PedidoResponseDTO;
import com.pieropan.kafka.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    @Mapping(target = "horario", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", ignore = true)
    Pedido toPedido(PedidoDTO pedidoDTO);

    PedidoResponseDTO toPedidoDto(Pedido pedido);
}