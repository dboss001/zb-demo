package com.example.demo;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


@EnableBinding(Sink.class)
@SpringBootApplication
public class SinkApp {
	
	private static Logger log = LoggerFactory.getLogger(SinkApp.class);
	
	private static String FILE_NAME = "C:\\\\Users\\\\dbosec\\\\Desktop\\\\zaba-demo\\\\output_employee.csv";
	private CsvSchema bootstrapSchema = CsvSchema.builder()
			                .addColumn("firstName", CsvSchema.ColumnType.STRING)
			                .addColumn("lastName", CsvSchema.ColumnType.STRING)
			                .build().withHeader();
    private CsvMapper mapper = new CsvMapper();
    private File file = new File(FILE_NAME);
	
    public static void main(String[] args) {
        SpringApplication.run(SinkApp.class, args);
    }
    
    
    @StreamListener(Sink.INPUT)
    public void logger(Employee payload) {
    	log.info("received {}", payload);
    	
    	List<Employee> list = loadObjectList(Employee.class);
    	list.add(payload);
    	saveObjectList(Employee.class, list);
    	
    }
    
    
    public <T> List<T> loadObjectList(Class<T> type) {
        try {
            
            MappingIterator<T> readValues = 
              mapper.readerFor(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
            
        } catch (Exception e) {
        	log.error("Error occurred while loading object list from file " + FILE_NAME, e);
            return Collections.emptyList();
        }
    }
    
    public <T> void saveObjectList(Class<T> type, List<T> list) {
        try {

            SequenceWriter writeValues = mapper.writerFor(type).with(bootstrapSchema).writeValues(file);
            writeValues.writeAll(list);

        } catch (Exception e) {
        	log.error("Error occurred while saving object list to file " + FILE_NAME, e);
        }
    }
    
}
