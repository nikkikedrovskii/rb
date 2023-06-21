package com.example.demo.core.document.mapper;

import com.example.demo.core.document.domain.Document;
import com.example.demo.entrypoints.model.request.document.UpdateDocumentRequest;
import org.mapstruct.Mapper;

@Mapper
public interface UpdateDocumentInput2DocumentMapper {

    Document map(UpdateDocumentRequest updateDocumentRequest);
}
