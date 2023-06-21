package com.example.demo.jpa_adapter.protocol.adapter;

import com.example.demo.core.protocol.adapter.ProtocolRepositoryAdapter;
import com.example.demo.core.protocol.domain.Protocol;
import com.example.demo.jpa.common.enumeration.ProtocolStateEnum;
import com.example.demo.jpa.document.entity.DocumentEntity;
import com.example.demo.jpa.document.repository.DocumentEntityRepository;
import com.example.demo.jpa.protocol.entity.ProtocolEntity;
import com.example.demo.jpa.protocol.repository.ProtocolEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProtocolJpaRepositoryAdapter implements ProtocolRepositoryAdapter {

    private final ProtocolEntityRepository protocolEntityRepository;
    private final DocumentEntityRepository documentEntityRepository;


    @Override
    public void createProtocol(Protocol protocol) {
        var protocolEntity = new ProtocolEntity();
        var listOfDocumentId = protocol.getListOfDocument();

        protocolEntity.setCreatorName(protocol.getCreatorName());
        protocolEntity.setProtocolState(protocol.getProtocolState());
        protocolEntity.setDocumentEntityList(getListOfDocumentEntity(listOfDocumentId));

        protocolEntityRepository.save(protocolEntity);
    }

    @Override
    public void updateProtocol(Long protocolId, Protocol protocol) {
         var protocolEntity = protocolEntityRepository.findById(protocolId)
                 .orElseThrow(() -> new RuntimeException("Protocol not found"));

        var listOfDocumentId = protocol.getListOfDocument();

        protocolEntity.setCreatorName(protocol.getCreatorName());
        protocolEntity.setProtocolState(protocol.getProtocolState());
        protocolEntity.setDocumentEntityList(getListOfDocumentEntity(listOfDocumentId));

        protocolEntityRepository.save(protocolEntity);
    }

    private List<DocumentEntity> getListOfDocumentEntity(List<Long> listOfDocumentId) {
        var listOfDocumentEntity = new ArrayList<DocumentEntity>();
        listOfDocumentId.forEach(documentId -> {
            var documentEntity = documentEntityRepository.findById(documentId)
                    .orElseThrow(() -> new RuntimeException("Document not exist. Id -" + documentId));
            listOfDocumentEntity.add(documentEntity);

        });
        return listOfDocumentEntity;
    }

    @Override
    public void updateProtocolState(Long protocolId, ProtocolStateEnum protocolStateEnum) {

        var protocolEntity = protocolEntityRepository.findById(protocolId)
                .orElseThrow(() -> new RuntimeException("Protocol not found"));

        protocolEntity.setProtocolState(protocolStateEnum);

        protocolEntityRepository.save(protocolEntity);
    }
}
