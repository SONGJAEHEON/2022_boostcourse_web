package kr.or.connect.reservation.dao;

import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

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
			
			rv.setId(rs.getInt("id"));
			rv.setDescription(rs.getString("description"));
			rv.setFileName(rs.getString("save_file_name"));
			rv.setLowPrice(rs.getInt("price"));
			String str = rs.getString("opening_hours");
			StringTokenizer stk = new StringTokenizer(str, "\n");
			rv.setOpeningHour1(stk.nextToken());
			try {
				str = stk.nextToken();
			}catch (Exception e){
				e.printStackTrace();
			}
			rv.setOpeningHour2(str);
			rv.setPlaceLot(rs.getString("place_lot"));
			rv.setPlaceStreet(rs.getString("place_street"));
			rv.setReservationCnt(3000 - rs.getInt("cnt"));
			rv.setFileName(rs.getString("save_file_name"));
			
			return rv;
		}
	}
}
