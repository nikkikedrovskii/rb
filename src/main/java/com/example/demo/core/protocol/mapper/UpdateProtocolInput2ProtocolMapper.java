package com.example.demo.core.protocol.mapper;

import com.example.demo.core.protocol.domain.Protocol;
import com.example.demo.entrypoints.model.request.protocol.UpdateProtocolRequest;
import org.mapstruct.Mapper;

@Mapper
public interface UpdateProtocolInput2ProtocolMapper {

    Protocol map(UpdateProtocolRequest updateProtocolRequest);
}
