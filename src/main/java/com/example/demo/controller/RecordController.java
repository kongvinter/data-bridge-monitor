package com.example.demo.controller; // Ajustado para a nova pasta

import com.example.demo.model.RecordEntity; // Import atualizado
import com.example.demo.repository.RecordRepository; // Import atualizado
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordRepository repository;

    public RecordController(RecordRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public RecordEntity create(@RequestBody RecordEntity record) {
        return repository.save(record);
    }

    @GetMapping
    public List<RecordEntity> listAll() {
        return repository.findAll();
    }
}
