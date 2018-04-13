package demo.jobs;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.tasklet.GroupTotalTasklet;

@Component
public class InsertGroupTotalsStep4 {

	public static String NAME = "insertGroupTotals";
    
    private Step step;
    
    
    @Autowired
    public InsertGroupTotalsStep4(StepBuilderFactory stepBuilderFactory, GroupTotalTasklet task) {
    	
    	step = stepBuilderFactory.get(NAME)
                .tasklet(task)
                .build();
    }
	
	
	public Step getStep() {
        return step;
	}
	
}
