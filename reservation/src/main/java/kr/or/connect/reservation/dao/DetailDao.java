package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Detail;
import static kr.or.connect.reservation.dao.DetailDaoSqls.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DetailDao {
	private JdbcTemplate jdbcTemplate;
	
	public DetailDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Detail getDetails(int id) {
		return this.jdbcTemplate.queryForObject(GET_DETAILs, new detailMapper(), id);		
	}
	
	class detailMapper implements RowMapper<Detail>{
		public Detail mapRow(ResultSet rs, int rowNum) throws SQLException{
			Detail detail = new Detail();
			
			detail.setContent(rs.getString("product.content"));
			detail.setCount(rs.getInt("count"));
			detail.setScore(rs.getDouble("average"));
			detail.setId(rs.getInt("display_info.id"));
			detail.setDescription(rs.getString("product.description"));
			detail.setSave_file_name(rs.getString("file_info.save_file_name"));
			
			return detail;
		}
	}
}
