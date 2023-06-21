package com.example.demo.core.protocol.use_case;

import com.example.demo.core.protocol.adapter.ProtocolRepositoryAdapter;
import com.example.demo.jpa.common.enumeration.ProtocolStateEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProtocolStateUseCase {

    private final ProtocolRepositoryAdapter protocolRepositoryAdapter;

    public void execute(Long protocolId, ProtocolStateEnum protocolStateEnum) {
        protocolRepositoryAdapter.updateProtocolState(protocolId, protocolStateEnum);
    }

}
