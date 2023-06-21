package com.example.demo.jpa_adapter.document.adapter;

import com.example.demo.core.document.adapter.DocumentRepositoryAdapter;
import com.example.demo.core.document.domain.Document;
import com.example.demo.jpa.document.entity.DocumentEntity;
import com.example.demo.jpa.document.repository.DocumentEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DocumentJpaRepositoryAdapter implements DocumentRepositoryAdapter {

    private final DocumentEntityRepository documentEntityRepository;

    @Override
    public void createDocument(Document document) {
        var documentEntity = new DocumentEntity();
        documentEntity.setName(document.getDocumentName());
        documentEntity.setCreator(document.getCreatorName());
        documentEntity.setType(document.getDocumentType());
        documentEntityRepository.save(documentEntity);
    }

    @Override
    public void deleteDocumentByDocumentId(Long documentId) {
        documentEntityRepository.deleteById(documentId);
    }

    @Override
    public void updateDocument(Long documentId, Document document) {

        var documentEntity = documentEntityRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        documentEntity.setName(document.getDocumentName());
        documentEntity.setCreator(document.getCreatorName());
        documentEntity.setType(document.getDocumentType());

        documentEntityRepository.save(documentEntity);
    }
}
