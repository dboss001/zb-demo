package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;


@EnableBinding(Processor.class)
@SpringBootApplication
public class ProcessorApp {
	
	private static Logger log = LoggerFactory.getLogger(ProcessorApp.class);

	public static void main(String[] args) {
        SpringApplication.run(ProcessorApp.class, args);
    }

    
    @ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Employee transform(Employee payload) {
    	Employee transformed = new Employee();
    	
    	String firstName = payload.getFirstName().toUpperCase();
    	String lastName = payload.getLastName().toUpperCase();
    	
    	transformed.setFirstName(firstName);
    	transformed.setLastName(lastName);
    	
        log.info("Processor received {}", transformed);
        return transformed;
    }
}
