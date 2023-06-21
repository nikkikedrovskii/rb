package com.example.demo.jpa.protocol.entity;

import com.example.demo.jpa.common.entity.GeneralEntity;
import com.example.demo.jpa.common.enumeration.ProtocolStateEnum;
import com.example.demo.jpa.document.entity.DocumentEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "protocol")
@SequenceGenerator(name = "protocol_id_seq_gen", sequenceName = "protocol_id_seq", allocationSize = 1)
public class ProtocolEntity extends GeneralEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "protocol_id_seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "creator_name")
    private String creatorName;

    @Enumerated(EnumType.STRING)
    @Column(name = "protocol_state")
    private ProtocolStateEnum protocolState;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "protocol_id")
    private List<DocumentEntity> documentEntityList;

}
