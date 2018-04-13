package demo.readers;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import demo.domain.Group;
import demo.mappers.GroupJdbcRowMapper;

@Component
@StepScope
public class GroupJdbcReader extends JdbcCursorItemReader<Group> {

	public static String NAME = "groupJdbcReader";
	
	public static String SQL = "SELECT distinct group_name FROM input_source where document_name = ";
	
	
	@Autowired
	public GroupJdbcReader (DataSource dataSource, GroupJdbcRowMapper mapper,
			@Value("#{jobParameters[docId]}") String p_docId) {
		setName(NAME);
		setDataSource(dataSource);
		setSql(SQL + "'" + p_docId + "'");
		setRowMapper(mapper);	
	}
	
}
