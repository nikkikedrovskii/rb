package com.example.demo.core.document.mapper;

import com.example.demo.core.document.domain.Document;
import com.example.demo.entrypoints.model.request.document.CreateDocumentRequest;
import org.mapstruct.Mapper;

@Mapper
public interface CreateDocumentInput2DocumentMapper {

    Document map(CreateDocumentRequest createDocumentRequest);
}
