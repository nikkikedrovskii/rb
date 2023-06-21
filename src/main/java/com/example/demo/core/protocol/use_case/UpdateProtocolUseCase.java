package com.example.demo.core.protocol.use_case;

import com.example.demo.core.protocol.adapter.ProtocolRepositoryAdapter;
import com.example.demo.core.protocol.domain.Protocol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProtocolUseCase {

    private final ProtocolRepositoryAdapter protocolRepositoryAdapter;

    public void execute(Long protocolId, Protocol protocol) {
        protocolRepositoryAdapter.updateProtocol(protocolId, protocol);
    }

}
