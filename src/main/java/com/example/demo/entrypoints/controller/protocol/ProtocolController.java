package com.example.demo.entrypoints.controller.protocol;

import com.example.demo.core.protocol.ProtocolFacade;
import com.example.demo.entrypoints.model.request.protocol.CreateProtocolRequest;
import com.example.demo.entrypoints.model.request.protocol.UpdateProtocolRequest;
import com.example.demo.entrypoints.model.request.protocol.UpdateProtocolStateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProtocolController {

    private final ProtocolFacade protocolFacade;

    @PostMapping(value = {"/protocol"})
    @PreAuthorize("hasAuthority('" + "ROLE_ADMIN" + "')")
    public ResponseEntity<Void> createProtocol(@RequestBody CreateProtocolRequest createProtocolRequest) {
        protocolFacade.createProtocol(createProtocolRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = {"/protocol/{protocolId}"})
    @PreAuthorize("hasAuthority('" + "ROLE_ADMIN" + "')")
    public ResponseEntity<Void> updateProtocol(@PathVariable Long protocolId, @RequestBody UpdateProtocolRequest updateProtocolRequest) {
        protocolFacade.updateProtocol(protocolId, updateProtocolRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = {"/protocol/{protocolId}/state"})
    @PreAuthorize("hasAuthority('" + "ROLE_ADMIN" + "')")
    public ResponseEntity<Void> updateProtocolState(@PathVariable Long protocolId, @RequestBody UpdateProtocolStateRequest updateProtocolStateRequest) {
        protocolFacade.updateProtocolState(protocolId, updateProtocolStateRequest);
        return ResponseEntity.ok().build();
    }
}
