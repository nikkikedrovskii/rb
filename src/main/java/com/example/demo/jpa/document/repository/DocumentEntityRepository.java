package com.example.demo.jpa.document.repository;

import com.example.demo.jpa.document.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentEntityRepository extends JpaRepository<DocumentEntity, Long> {

    List<DocumentEntity> findAllByIdIn(List<Long> listOfDocumentId);
}
