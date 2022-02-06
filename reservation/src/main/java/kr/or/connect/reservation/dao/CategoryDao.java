package kr.or.connect.reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import static kr.or.connect.reservation.dao.CategoryDaoSqls.*;

@Repository
public class CategoryDao {
	private final JdbcTemplate jdbcTemplate;
	
	public CategoryDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Category> selectAll() {
		return this.jdbcTemplate.query(SELECT_CATs, new categoryMapper());
	}
	
	class categoryMapper implements RowMapper<Category>{
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException{
			Category cat = new Category();
			
			cat.setId(rs.getLong("id"));
			cat.setName(rs.getString("name"));
			
			return cat;
		}
	}
}
