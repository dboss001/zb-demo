package demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import demo.domain.Group;

@Component
public class GroupJdbcRowMapper implements RowMapper<Group> {

	@Override
	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {

		Group result = new Group();

		result.setName(rs.getString("group_name"));
		
		return result;
	}

}
