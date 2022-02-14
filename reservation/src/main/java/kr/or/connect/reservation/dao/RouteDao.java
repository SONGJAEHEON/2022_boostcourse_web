package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Route;
import static kr.or.connect.reservation.dao.RouteDaoSqls.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RouteDao {
	private JdbcTemplate jdbcTemplate;
	
	public RouteDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Route getRoute(int id) {
		return this.jdbcTemplate.queryForObject(GET_ROUTE, new routeMapper(), id);
	}
	
	class routeMapper implements RowMapper<Route>{
		public Route mapRow(ResultSet rs, int rowNum) throws SQLException{
			Route route = new Route();
			
			route.setPlace_lot(rs.getString("place_lot"));
			route.setPlace_name(rs.getString("place_name"));
			route.setPlace_street(rs.getString("place_street"));
			route.setSave_file_name(rs.getString("save_file_name"));
			route.setTel(rs.getString("tel"));
			
			return route;
		}
	}
}
