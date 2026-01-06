package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String NOTIF_CHANNEL = "new_event_channel";

   public void sendtrigger(Object id) {
        if (id == null) {
            System.out.println("Erro: ID recebido é nulo!");
            return;
        }

        try {

            String payload = "{\"id\": \"" + id.toString() + "\", \"status\": \"success\"}";


            String sql = "NOTIFY " + NOTIF_CHANNEL + ", '" + payload + "'";

            jdbcTemplate.execute(sql);
            System.out.println("send to postgres! ID: " + id);

        } catch (Exception e) {
            System.err.println("error trigger: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
