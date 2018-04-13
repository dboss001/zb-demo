package demo.writers;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import demo.domain.Item;

@Component
public class ItemJdbcWriter extends JdbcBatchItemWriter<Item> {

	public static String SQL = "INSERT INTO output_item (id, name, amount, document_id, group_id) VALUES (:id, :name, :amount, :documentId, :groupId)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ItemJdbcWriter(DataSource dataSource) {
		setAssertUpdates(Boolean.TRUE);
		setDataSource(dataSource);
		setSql(SQL);
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Item>());
		afterPropertiesSet();
	}

	@Override
	public void write(List<? extends Item> items) throws Exception {
		for(Item item : items) {
			Long id = (Long) jdbcTemplate.queryForObject(
	    			"select next value for output_item_seq from dual", Long.class);
			item.setId(id);
		}
		super.write(items);
	}
	
}
