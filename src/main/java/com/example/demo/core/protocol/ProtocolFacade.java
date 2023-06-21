package com.example.demo.core.protocol;

import com.example.demo.core.protocol.mapper.CreateProtocolInput2ProtocolMapper;
import com.example.demo.core.protocol.mapper.UpdateProtocolInput2ProtocolMapper;
import com.example.demo.core.protocol.use_case.CreateProtocolUseCase;
import com.example.demo.core.protocol.use_case.UpdateProtocolStateUseCase;
import com.example.demo.core.protocol.use_case.UpdateProtocolUseCase;
import com.example.demo.entrypoints.model.request.protocol.CreateProtocolRequest;
import com.example.demo.entrypoints.model.request.protocol.UpdateProtocolRequest;
import com.example.demo.entrypoints.model.request.protocol.UpdateProtocolStateRequest;
import com.example.demo.jpa.common.enumeration.ProtocolStateEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProtocolFacade {

    private final CreateProtocolUseCase createProtocolUseCase;
    private final UpdateProtocolUseCase updateProtocolUseCase;
    private final UpdateProtocolStateUseCase updateProtocolStateUseCase;
    private final CreateProtocolInput2ProtocolMapper createProtocolInput2ProtocolMapper;
    private final UpdateProtocolInput2ProtocolMapper updateProtocolInput2ProtocolMapper;

    public void createProtocol(CreateProtocolRequest createProtocolRequest){
        var protocolDomain = createProtocolInput2ProtocolMapper.map(createProtocolRequest);
        createProtocolUseCase.execute(protocolDomain);
    }

    public void updateProtocol(Long protocolId, UpdateProtocolRequest updateProtocolRequest){
        var protocolDomain = updateProtocolInput2ProtocolMapper.map(updateProtocolRequest);
        updateProtocolUseCase.execute(protocolId,protocolDomain);
    }

    public void updateProtocolState(Long protocolId, UpdateProtocolStateRequest updateProtocolStateRequest){
        var protocolStateDomain = ProtocolStateEnum.valueOf(updateProtocolStateRequest.getProtocolState());
        updateProtocolStateUseCase.execute(protocolId,protocolStateDomain);
    }
}
