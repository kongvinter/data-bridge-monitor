package com.example.demo.controller; 

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RecordEntity;
import com.example.demo.repository.RecordRepository;

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
