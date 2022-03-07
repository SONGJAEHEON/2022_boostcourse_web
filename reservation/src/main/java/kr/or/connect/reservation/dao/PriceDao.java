package kr.or.connect.reservation.dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.Price;
import static kr.or.connect.reservation.dao.PriceDaoSqls.*;


@Repository
public class PriceDao {
private NamedParameterJdbcTemplate jdbcTemplate;
	
	public PriceDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Price> getPriceInfos(int id){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return this.jdbcTemplate.query(GET_PRICE_INFOs, params, new PriceMapper());
	}
	
	class PriceMapper implements RowMapper<Price>{
		public Price mapRow(ResultSet rs, int rowNum) throws SQLException{
			Price price = new Price();
			
			price.setType(rs.getString("price_type_name"));
			price.setPrice(rs.getInt("price"));
			price.setDiscount_rate(rs.getInt("discount_rate"));
			
			return price;
		}
	}
}
