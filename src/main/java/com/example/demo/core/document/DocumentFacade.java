package com.example.demo.core.document;

import com.example.demo.core.document.mapper.CreateDocumentInput2DocumentMapper;
import com.example.demo.core.document.mapper.UpdateDocumentInput2DocumentMapper;
import com.example.demo.core.document.use_case.CreateDocumentUseCase;
import com.example.demo.core.document.use_case.DeleteDocumentUseCase;
import com.example.demo.core.document.use_case.UpdateDocumentUseCase;
import com.example.demo.entrypoints.model.request.document.CreateDocumentRequest;
import com.example.demo.entrypoints.model.request.document.UpdateDocumentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentFacade {

    private final CreateDocumentUseCase createDocumentUseCase;
    private final DeleteDocumentUseCase deleteDocumentUseCase;
    private final UpdateDocumentUseCase updateDocumentUseCase;
    private final CreateDocumentInput2DocumentMapper createDocumentInput2DocumentMapper;
    private final UpdateDocumentInput2DocumentMapper updateDocumentInput2DocumentMapper;


    public void createDocument(CreateDocumentRequest createDocumentRequest){
        var documentDomain = createDocumentInput2DocumentMapper.map(createDocumentRequest);
        createDocumentUseCase.execute(documentDomain);
    }

    public void deleteDocument(Long documentId){
        deleteDocumentUseCase.execute(documentId);
    }

    public void updateDocument(Long documentId, UpdateDocumentRequest updateDocumentRequest){
        var documentDomain = updateDocumentInput2DocumentMapper.map(updateDocumentRequest);
        updateDocumentUseCase.execute(documentId,documentDomain);
    }

}
