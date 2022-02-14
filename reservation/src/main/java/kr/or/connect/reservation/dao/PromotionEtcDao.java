package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.PromotionEtcDaoSqls.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Promotion;

@Repository
public class PromotionEtcDao {
	private final JdbcTemplate jdbcTemplate;
	
	public PromotionEtcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Promotion getEtc(int id) {
		return this.jdbcTemplate.queryForObject(GET_ETC, new promotionMapper(), id);
	}
	
	class promotionMapper implements RowMapper<Promotion>{
		public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException{
			Promotion promo = new Promotion();
			
			promo.setId(rs.getInt("display_info.id"));
			promo.setSave_file_name(rs.getString("file_info.save_file_name"));
			
			return promo;
		}
	}
}
