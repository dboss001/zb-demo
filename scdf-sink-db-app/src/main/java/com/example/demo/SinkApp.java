package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


@EnableBinding(Sink.class)
@SpringBootApplication
public class SinkApp {
	
	private static Logger log = LoggerFactory.getLogger(SinkApp.class);
	
	private static ConfigurableApplicationContext context;
	private static JdbcTemplate jdbcTemplate;
	
    public static void main(String[] args) {
        context = SpringApplication.run(SinkApp.class, args);
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    @StreamListener(Sink.INPUT)
    public void logger(Employee payload) {
    	log.info("received {}", payload);
        
        jdbcTemplate.update(
			    "INSERT INTO output_employee (first_name, last_name) VALUES (?, ?)",
			    payload.getFirstName(), payload.getLastName()
			);
    }
}
