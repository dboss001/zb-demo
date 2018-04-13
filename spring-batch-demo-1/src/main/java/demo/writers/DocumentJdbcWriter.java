package demo.writers;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import demo.domain.Document;

@Component
public class DocumentJdbcWriter extends JdbcBatchItemWriter<Document> {

	public static String SQL = "INSERT INTO output_document (id, name) VALUES (:id, :name)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private StepExecution stepExecution;
	
	
	@Autowired
	public DocumentJdbcWriter(DataSource dataSource) {
		setAssertUpdates(Boolean.TRUE);
		setDataSource(dataSource);
		setSql(SQL);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Document>());
		afterPropertiesSet();
	}

	@Override
	public void write(List<? extends Document> items) throws Exception {
		for(Document item : items) {
			Long id = (Long) jdbcTemplate.queryForObject(
					"select next value for output_document_seq from dual", Long.class);
			item.setId(id);
			stepExecution.getExecutionContext().put("DOCUMENT_ID", id);
		}
		super.write(items);
	}
	
	@BeforeStep
	public void retrieveInterstepData(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}
	
}
