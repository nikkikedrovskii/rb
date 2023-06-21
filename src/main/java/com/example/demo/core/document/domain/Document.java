package com.example.demo.core.document.domain;

import com.example.demo.jpa.common.enumeration.DocumentTypeEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Document {

    private String documentName;
    private String creatorName;
    private DocumentTypeEnum documentType;
}
