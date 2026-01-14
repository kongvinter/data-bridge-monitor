package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RecordEntity;
import com.example.demo.repository.RecordRepository;
import com.example.demo.service.NotificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordRepository repository;
    private final NotificationService notificationService;


    public RecordController(RecordRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    @PostMapping
    public RecordEntity create(@Valid @RequestBody RecordEntity record) {

        RecordEntity savedRecord = repository.save(record);


        notificationService.sendtrigger(savedRecord.getId());

        return savedRecord;
    }

    @GetMapping
    public List<RecordEntity> listAll() {
        return repository.findAll();
    }
}
