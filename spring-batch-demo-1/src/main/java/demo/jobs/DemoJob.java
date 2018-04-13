package demo.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.stereotype.Component;

@Component
public class DemoJob {

	public static String NAME = "demoJob-11";
    
    private Job job;
    
    public DemoJob(JobBuilderFactory jobBuilderFactory, InsertDocumentStep1 step1, 
    		InsertGroupStep2 step2, InsertItemStep3 step3, InsertGroupTotalsStep4 step4, InsertDocumentTotalsStep5 step5) {
    	
    	job = jobBuilderFactory.get(NAME)
				.incrementer(new RunIdIncrementer())
                .start(step1.getStep())
                .next(step2.getStep())
                .next(step3.getStep())
                .next(step4.getStep())
                .next(step5.getStep())
                .build();
    }
	
	
	public Job getJob() {
        return job;
	}
	
}
