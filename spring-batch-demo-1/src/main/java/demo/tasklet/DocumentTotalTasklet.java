package demo.tasklet;

import java.math.BigDecimal;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class DocumentTotalTasklet implements Tasklet {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("#{jobExecutionContext[DOCUMENT_ID]}")
    private Long documentId;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
	
		BigDecimal totalAmount = jdbcTemplate.queryForObject(
				"SELECT sum(amount) FROM output_item WHERE document_id = ?", 
				new Object[] { documentId }, 
				BigDecimal.class);
		
		Long id = jdbcTemplate.queryForObject("select next value for output_total_seq from dual", Long.class);
		
		jdbcTemplate.update(
			    "INSERT INTO output_total (id, amount, document_id) VALUES (?, ?, ?)",
			    id, totalAmount, documentId
			);

		return RepeatStatus.FINISHED;
	}

}
