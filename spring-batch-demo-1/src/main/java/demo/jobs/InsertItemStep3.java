package demo.jobs;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.domain.Input;
import demo.domain.Item;
import demo.processors.ItemsProcessor;
import demo.readers.InputJdbcReader;
import demo.writers.ItemJdbcWriter;

@Component
public class InsertItemStep3 {

	public static String NAME = "insertItems";
	
	public static int CHUNK_SIZE = 100;
    
    private Step step;
    
    @Autowired
    public InsertItemStep3(StepBuilderFactory stepBuilderFactory, InputJdbcReader reader, ItemsProcessor processor, ItemJdbcWriter writer) {
    	
    	step = stepBuilderFactory.get(NAME)
                .<Input, Item> chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
	
	
	public Step getStep() {
        return step;
	}
	
}
