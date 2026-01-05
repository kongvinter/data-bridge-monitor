package com.example.demo.model; // Caminho completo atualizado

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "raw_records")
public class RecordEntity {
    @Id
    private UUID id;

    private String data;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Construtor padrão (Obrigatório para o Hibernate/JPA)
    public RecordEntity() {}

    // Construtor para facilitar a criação de novos registros
    public RecordEntity(UUID id, String data) {
        this.id = id;
        this.data = data;
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

}
