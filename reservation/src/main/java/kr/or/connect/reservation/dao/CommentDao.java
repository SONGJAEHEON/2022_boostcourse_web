package kr.or.connect.reservation.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.Comment;
import static kr.or.connect.reservation.dao.CommentSqls.*;

@Repository
public class CommentDao {
	private final NamedParameterJdbcTemplate jdbcTemplate;

	public CommentDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Comment> getComments(int id, int cnt) {
		Map<String, Integer> params = new HashMap();

		params.put("id", id);
		params.put("cnt", cnt);

		if (cnt == 0) {
			return this.jdbcTemplate.query(GET_COMMENTS_ALL, params, new CommentsMapper());
		} else {
			params.put("cnt", cnt);
			return this.jdbcTemplate.query(GET_COMMENTS_SOME, params, new CommentsMapper());
		}
	}

	class CommentsMapper implements RowMapper<Comment> {
		public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Comment cmnt = new Comment();
			
			cmnt.setComment(rs.getString("comment"));
			cmnt.setDescription(rs.getString("product.description"));
			cmnt.setModify_date(rs.getString("reservation_user_comment.modify_date"));
			cmnt.setReservation_email(rs.getString("reservation_email"));
			cmnt.setSave_file_name(rs.getString("save_file_name"));
			cmnt.setScore(rs.getInt("score"));

			return cmnt;
		}
	}

}
