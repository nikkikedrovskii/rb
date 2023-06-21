package com.example.demo.jpa.document.entity;

import com.example.demo.jpa.common.entity.GeneralEntity;
import com.example.demo.jpa.common.enumeration.DocumentTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "document")
@SequenceGenerator(name = "document_id_seq_gen", sequenceName = "document_id_seq", allocationSize = 1)
public class DocumentEntity extends GeneralEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_id_seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "document_name")
    private String name;

    @Column(name = "creator_name")
    private String creator;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private DocumentTypeEnum type;

}
