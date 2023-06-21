package com.example.demo.entrypoints.controller.document;

import com.example.demo.core.document.DocumentFacade;
import com.example.demo.entrypoints.model.request.document.CreateDocumentRequest;
import com.example.demo.entrypoints.model.request.document.UpdateDocumentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DocumentController {

    private final DocumentFacade documentFacade;

    @PostMapping(value = {"/document"})
    @PreAuthorize("hasAuthority('" + "ROLE_ADMIN" + "')")
    public ResponseEntity<Void> createDocument(@RequestBody CreateDocumentRequest createDocumentRequest) {
        documentFacade.createDocument(createDocumentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = {"/document/{documentId}"})
    @PreAuthorize("hasAuthority('" + "ROLE_ADMIN" + "')")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long documentId) {
        documentFacade.deleteDocument(documentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = {"/document/{documentId}"})
    @PreAuthorize("hasAuthority('" + "ROLE_ADMIN" + "')")
    public ResponseEntity<Void> updateDocument(@PathVariable Long documentId, @RequestBody UpdateDocumentRequest updateDocumentRequest) {
        documentFacade.updateDocument(documentId, updateDocumentRequest);
        return ResponseEntity.ok().build();
    }
}
