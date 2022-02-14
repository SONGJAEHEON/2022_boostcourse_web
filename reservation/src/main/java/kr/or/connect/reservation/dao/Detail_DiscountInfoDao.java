package kr.or.connect.reservation.dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.sql.DataSource;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.Detail_DiscountInfo;
import static kr.or.connect.reservation.dao.Detail_DiscountInfoDaoSqls.*;

import java.sql.ResultSet;

@Repository
public class Detail_DiscountInfoDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public Detail_DiscountInfoDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Detail_DiscountInfo> getDiscountInfosA(int id){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return this.jdbcTemplate.query(GET_DISCOUNT_INFOs_A, params, new Detail_DiscountInfoMapper());
	}
	
	public List<Detail_DiscountInfo> getDiscountInfosB(int id){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return this.jdbcTemplate.query(GET_DISCOUNT_INFOs_B, params, new Detail_DiscountInfoMapper());
	}
	
	class Detail_DiscountInfoMapper implements RowMapper<Detail_DiscountInfo>{
		public Detail_DiscountInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
			Detail_DiscountInfo de = new Detail_DiscountInfo();
			
			de.setPrice_type_name(rs.getString("price_type_name"));
			de.setDiscount_rate(rs.getInt("discount_rate"));
			
			return de;
		}
	}
}
