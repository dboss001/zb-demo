package demo;

import javax.sql.DataSource;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.DatabaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ApplicationConfig {

    @Autowired
	private DataSource dataSource;
    
    @Autowired
    private PlatformTransactionManager transactionManager; 
    
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//    
//    @Autowired
//    private InsertDocumentStep1 step1;
//    
//    @Autowired
//    private InsertGroupStep2 step2;
//	
//    @Autowired
//    private InsertItemStep3 step3;
//	
//    @Autowired
//    private InsertGroupTotalsStep4 step4;
//	
//    @Autowired
//    private InsertDocumentTotalsStep5 step5;
    
	
	@Bean
    public JobRepository jobRepository() throws Exception {
    	JobRepositoryFactoryBean  repository = new JobRepositoryFactoryBean();
    	repository.setDataSource(dataSource);
    	repository.setTransactionManager(transactionManager);
    	repository.setDatabaseType(DatabaseType.MYSQL.name());
    	return repository.getObject();
    }
    
	
//	@Bean
//	public Job demoJob1() {
//		return jobBuilderFactory.get("demoJob-1")
//				.incrementer(new RunIdIncrementer())
//                .start(step1.getStep())
//                .next(step2.getStep())
//                .next(step3.getStep())
//                .next(step4.getStep())
//                .next(step5.getStep())
//                .build();
//	}

    
//    @PostConstruct
//	public void startDBManager() {
//		
//		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
//	}
    
    
    
}
