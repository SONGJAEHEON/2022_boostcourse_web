package kr.or.connect.reservation.dao;

import java.util.Map;
import java.util.HashMap;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.Reservation;
import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public ReservationDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Reservation select(int id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(SELECT, params, new ReservationMapper());
	}
	
	class ReservationMapper implements RowMapper<Reservation>{
		public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException{
			Reservation rv = new Reservation();
			
			rv.setDescription(rs.getString("description"));
			rv.setLowPrice(rs.getInt("price"));
			rv.setOpeningHour(rs.getString("opening_hours"));
			rv.setPlaceLot(rs.getString("place_lot"));
			rv.setPlaceStreet(rs.getString("place_street"));
			rv.setReservationCnt(rs.getInt("cnt"));
			
			return rv;
		}
	}
}