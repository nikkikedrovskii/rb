package com.example.demo.core.document.adapter;

import com.example.demo.core.document.domain.Document;

public interface DocumentRepositoryAdapter {

    void createDocument(Document document);

    void deleteDocumentByDocumentId(Long documentId);

    void updateDocument(Long documentId, Document document);
}
