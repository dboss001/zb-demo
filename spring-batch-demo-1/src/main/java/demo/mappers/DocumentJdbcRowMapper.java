package demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import demo.domain.Document;

@Component
public class DocumentJdbcRowMapper implements RowMapper<Document> {

	@Override
	public Document mapRow(ResultSet rs, int rowNum) throws SQLException {

		Document result = new Document();

		result.setName(rs.getString("document_name"));
		
		return result;
	}

}
