package demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import demo.domain.Input;

@Component
public class InputJdbcRowMapper implements RowMapper<Input> {

	@Override
	public Input mapRow(ResultSet rs, int rowNum) throws SQLException {

		Input result = new Input();

		result.setDocumentName(rs.getString("document_name"));
		result.setGroupName(rs.getString("group_name"));
		result.setItemName(rs.getString("item_name"));
		result.setAmount(rs.getBigDecimal("amount"));
		
		return result;
	}

}
