package com.example.demo.entrypoints.model.request.document;

import lombok.Data;

@Data
public class CreateDocumentRequest {

    private String documentName;
    private String creatorName;
    private String documentType;

}
