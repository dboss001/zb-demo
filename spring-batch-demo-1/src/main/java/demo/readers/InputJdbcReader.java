package demo.readers;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import demo.domain.Input;
import demo.mappers.InputJdbcRowMapper;

@Component
@StepScope
public class InputJdbcReader extends JdbcCursorItemReader<Input> {

	public static String NAME = "inputJdbcReader";
	
	public static String SQL = "SELECT document_name, group_name, item_name, amount FROM input_source where document_name = ";
	
	
	@Autowired
	public InputJdbcReader (DataSource dataSource, InputJdbcRowMapper mapper,
			@Value("#{jobParameters[docId]}") String p_docId) {
		setName(NAME);
		setDataSource(dataSource);
		setSql(SQL + "'" + p_docId + "'");
		setRowMapper(mapper);	
	}	
	
}
