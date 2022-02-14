package kr.or.connect.reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Display_info;

import static kr.or.connect.reservation.dao.Display_infoDaoSqls.*;

@Repository
public class Display_infoDao {
	private NamedParameterJdbcTemplate jdbcTemplate;

	public Display_infoDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Display_info> selectAll(int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbcTemplate.query(SELECT_ALL, params, new Display_infoMapper());
	}
	
	public List<Display_info> selectSpecific(int cat, int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("cat", cat);
		params.put("start", start);
		params.put("limit", limit);
		return jdbcTemplate.query(SELECT_SPECIFIC, params, new Display_infoMapper());
	}
	
	class Display_infoMapper implements RowMapper<Display_info>{
		public Display_info mapRow(ResultSet rs, int rowNum) throws SQLException{
			Display_info di = new Display_info();
			
			di.setId(rs.getInt("display_info.id"));
			di.setDescription(rs.getString("product.description"));
			di.setContent(rs.getString("product.content"));
			di.setPlace_name(rs.getString("display_info.place_name"));
			di.setSave_file_name(rs.getString("file_info.save_file_name"));
			
			return di;
		}
	}

	public int selectCount(int id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		if (id == 0)
			return jdbcTemplate.queryForObject(SELECT_COUNT_ALL, Collections.emptyMap(), Integer.class);
		else
			return jdbcTemplate.queryForObject(SELECT_COUNT_BY_ID, params, Integer.class);
	}
}
