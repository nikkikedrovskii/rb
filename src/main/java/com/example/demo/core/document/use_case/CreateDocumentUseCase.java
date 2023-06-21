package com.example.demo.core.document.use_case;

import com.example.demo.core.document.adapter.DocumentRepositoryAdapter;
import com.example.demo.core.document.domain.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDocumentUseCase {

    private final DocumentRepositoryAdapter documentRepositoryAdapter;

    public void execute(Document document) {
        documentRepositoryAdapter.createDocument(document);
    }
}
