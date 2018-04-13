package demo.jobs;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.domain.Group;
import demo.processors.GroupProcessor;
import demo.readers.GroupJdbcReader;
import demo.writers.GroupJdbcWriter;

@Component
public class InsertGroupStep2 {

	public static String NAME = "insertGroups";
	
	public static int CHUNK_SIZE = 100;
    
    private Step step;
    
    
    @Autowired
    public InsertGroupStep2(StepBuilderFactory stepBuilderFactory, GroupJdbcReader reader, GroupProcessor processor, GroupJdbcWriter writer) {
    	
    	step = stepBuilderFactory.get(NAME)
                .<Group, Group> chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
	
	
	public Step getStep() {
        return step;
	}
	
}
