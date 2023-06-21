package com.example.demo.entrypoints.model.request.protocol;

import lombok.Data;

import java.util.List;

@Data
public class CreateProtocolRequest {

    private String creatorName;
    private String protocolState;
    private List<Long> listOfDocument;

}
