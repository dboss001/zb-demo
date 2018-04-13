package demo.jobs;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.tasklet.DocumentTotalTasklet;

@Component
public class InsertDocumentTotalsStep5 {

	public static String NAME = "insertDocumentTotals";
    
    private Step step;
    
    
    @Autowired
    public InsertDocumentTotalsStep5(StepBuilderFactory stepBuilderFactory, DocumentTotalTasklet task) {
    	
    	step = stepBuilderFactory.get(NAME)
                .tasklet(task)
                .build();
    }
	
	
	public Step getStep() {
        return step;
	}
	
}
