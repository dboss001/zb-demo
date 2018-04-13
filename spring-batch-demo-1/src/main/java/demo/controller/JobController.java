package demo.controller;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.jobs.DemoJob;

@RestController
public class JobController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
    private DemoJob job;
	
	@GetMapping("/runJob")
    public String greeting(
    		@RequestParam(name="docId", required=false, defaultValue="Doc1") String p_docId) throws Exception {

        JobParameters param = new JobParametersBuilder().addString("docId", p_docId).toJobParameters();
		JobExecution execution = jobLauncher.run(job.getJob(), param);
        
        return execution.getStatus().toString();
    }
	
}
