package com.example.demo.jpa.protocol.repository;

import com.example.demo.jpa.protocol.entity.ProtocolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtocolEntityRepository extends JpaRepository<ProtocolEntity, Long> {
}
