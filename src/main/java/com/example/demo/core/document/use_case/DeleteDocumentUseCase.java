package com.example.demo.core.document.use_case;

import com.example.demo.core.document.adapter.DocumentRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteDocumentUseCase {

    private final DocumentRepositoryAdapter documentRepositoryAdapter;

    public void execute(Long documentId) {
        documentRepositoryAdapter.deleteDocumentByDocumentId(documentId);
    }
}
