package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.PromotionDaoSqls.SELECT_PROMOTIONs;

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
public class PromotionDao {
	private final JdbcTemplate jdbcTemplate;
	
	public PromotionDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Promotion> getPromotions() {
		return this.jdbcTemplate.query(SELECT_PROMOTIONs, new promotionMapper());
	}
	
	class promotionMapper implements RowMapper<Promotion>{
		public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException{
			Promotion promo = new Promotion();
			
			promo.setId(rs.getInt("promotion.id"));
			promo.setSave_file_name(rs.getString("file_info.save_file_name"));
			
			return promo;
		}
	}
}
