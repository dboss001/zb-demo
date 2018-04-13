package demo.writers;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import demo.domain.Group;

@Component
public class GroupJdbcWriter extends JdbcBatchItemWriter<Group> {

	public static String SQL = "INSERT INTO output_group (id, name, document_id) VALUES (:id, :name, :documentId)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public GroupJdbcWriter(DataSource dataSource) {
		setAssertUpdates(Boolean.TRUE);
		setDataSource(dataSource);
		setSql(SQL);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Group>());
		afterPropertiesSet();
	}

	@Override
	public void write(List<? extends Group> items) throws Exception {		
		for(Group item : items) {
			Long id = (Long) jdbcTemplate.queryForObject(
	    			"select next value for output_group_seq from dual", Long.class);
			item.setId(id);
		}
		super.write(items);
	}
	
}
