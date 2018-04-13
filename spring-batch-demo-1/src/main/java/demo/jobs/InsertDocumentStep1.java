package demo.jobs;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.domain.Document;
import demo.listeners.PromotionListener;
import demo.processors.DocumentProcessor;
import demo.readers.DocumentJdbcReader;
import demo.writers.DocumentJdbcWriter;

@Component
public class InsertDocumentStep1 {

	public static String NAME = "insertDocument";
	
	public static int CHUNK_SIZE = 100;
    
    private Step step;
    

    
    
    @Autowired
    public InsertDocumentStep1(StepBuilderFactory stepBuilderFactory, DocumentJdbcReader reader, 
    		DocumentProcessor processor, DocumentJdbcWriter writer, PromotionListener promotionListener) {
    	
    	step = stepBuilderFactory.get(NAME)
                .<Document, Document> chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(promotionListener)
                .build();
    }
	
	
	public Step getStep() {
        return step;
	}
	
}
