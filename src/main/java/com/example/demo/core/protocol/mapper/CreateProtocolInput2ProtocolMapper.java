package com.example.demo.core.protocol.mapper;

import com.example.demo.core.protocol.domain.Protocol;
import com.example.demo.entrypoints.model.request.protocol.CreateProtocolRequest;
import org.mapstruct.Mapper;

@Mapper
public interface CreateProtocolInput2ProtocolMapper {

    Protocol map(CreateProtocolRequest createProtocolRequest);

}
