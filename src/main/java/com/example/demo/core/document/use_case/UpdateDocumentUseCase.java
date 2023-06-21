package com.example.demo.core.document.use_case;

import com.example.demo.core.document.adapter.DocumentRepositoryAdapter;
import com.example.demo.core.document.domain.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateDocumentUseCase {

    private final DocumentRepositoryAdapter documentRepositoryAdapter;

    public void execute(Long documentId, Document document) {
        documentRepositoryAdapter.updateDocument(documentId,document);
    }
}
