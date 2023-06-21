package com.example.demo.core.protocol.domain;

import com.example.demo.jpa.common.enumeration.ProtocolStateEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Protocol {

    private String creatorName;
    private ProtocolStateEnum protocolState;
    private List<Long> listOfDocument;
}
