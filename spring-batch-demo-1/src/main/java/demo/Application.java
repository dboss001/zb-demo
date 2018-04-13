package demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

//@EnableTask
@EnableBatchProcessing
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
    	
		@SuppressWarnings("unused")
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
 

    }
}
