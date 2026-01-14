package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.RecordEntity;
import com.example.demo.repository.RecordRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

  @Bean
  public CommandLineRunner run(RecordRepository recordRepository) {
      return args -> {
        System.out.println("application started successfully.");

          RecordEntity entity = new RecordEntity();
          entity.setData("TC-02 BROADCAST TESTE SUCCESSFUL");
          System.out.println("saving record...");
          recordRepository.save(entity);
          System.out.println("record saved with ID: " + entity.getId());
          System.out.println("you can listen to notifications on channel 'new_event_channel'");
      };
  }

}
