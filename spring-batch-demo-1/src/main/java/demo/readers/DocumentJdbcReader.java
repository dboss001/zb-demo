package demo.readers;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import demo.domain.Document;
import demo.mappers.DocumentJdbcRowMapper;

@Component
@StepScope
public class DocumentJdbcReader extends JdbcCursorItemReader<Document> {

	public static String NAME = "documentJdbcReader";
	
	public static String SQL = "SELECT distinct document_name FROM input_source where document_name = ";
    
	
	@Autowired
	public DocumentJdbcReader (DataSource dataSource, DocumentJdbcRowMapper mapper,
			@Value("#{jobParameters[docId]}") String p_docId) {
		setName(NAME);
		setDataSource(dataSource);
		setSql(SQL + "'" + p_docId + "'");
		setRowMapper(mapper);	
	}
	
}
