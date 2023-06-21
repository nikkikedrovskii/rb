package com.example.demo.core.protocol.adapter;

import com.example.demo.core.protocol.domain.Protocol;
import com.example.demo.jpa.common.enumeration.ProtocolStateEnum;

public interface ProtocolRepositoryAdapter {

    void createProtocol(Protocol protocol);

    void updateProtocol(Long protocolId, Protocol protocol);

    void updateProtocolState(Long protocolId, ProtocolStateEnum protocolStateEnum);

}
