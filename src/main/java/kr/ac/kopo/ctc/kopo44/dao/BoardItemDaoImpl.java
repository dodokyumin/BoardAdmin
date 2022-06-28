package kr.ac.kopo.ctc.kopo44.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo44.domain.BoardItem;

public class BoardItemDaoImpl implements BoardItemDao {

	public BoardItemDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}
	}

	@Override
	public int createOne(BoardItem BoardItem) {
		String sql = "INSERT INTO " + TABLE_NAME + "(title, date, content) VALUES (?, ?, ?)";
		int result;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, BoardItem.getTitle());
			pstmt.setString(2, BoardItem.getDate());
			pstmt.setString(3, BoardItem.getContent());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			throw new IllegalStateException("insert 실패 " + e.getMessage());
		}
		return result;
	}

	@Override
	public BoardItem readOne(int inputId) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
		
		BoardItem boardItem = new BoardItem();
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, inputId);
			try (ResultSet rs = pstmt.executeQuery();){
				
				rs.next();
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String date = rs.getString("date");
					String content = rs.getString("content");

					boardItem.setId(id);
					boardItem.setTitle(title);
					boardItem.setDate(date);
					boardItem.setContent(content);
			}
			
		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			throw new IllegalStateException("insert 실패 " + e.getMessage());
		}
		return boardItem;
	}

	@Override
	public List<BoardItem> readAll(int startIndex, int countPerPage) {
		List<BoardItem> results = new ArrayList<>();
		String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY "+ COULUMN_ID +" desc LIMIT ?, ?";
		// TRY RESOURCE CATCH문
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, startIndex - 1);
			pstmt.setInt(2, countPerPage);
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String date = rs.getString("date");
					String content = rs.getString("content");

					BoardItem boarditem = new BoardItem();
					boarditem.setId(id);
					boarditem.setTitle(title);
					boarditem.setDate(date);
					boarditem.setContent(content);

					results.add(boarditem);
				}
			}
		} catch (SQLException e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		return results;
	}

	@Override
	public BoardItem updateOne(BoardItem BoardItem) {
		String sql = "UPDATE " + TABLE_NAME + " SET title=?, date=?, content=? WHERE id = ?";
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			// pstmt.setString(1, TABLE_NAME);
			pstmt.setString(1, BoardItem.getTitle());
			pstmt.setString(2, BoardItem.getDate());
			pstmt.setString(3, BoardItem.getContent());
			pstmt.setInt(4, BoardItem.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// e만 넣으면 hashcode가 나오므로 getMessage()를 붙여준다.
			// throw new IllegalStateException("update 실패 " + e.getMessage());
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return BoardItem;
	}

	@Override
	public int deleteOne(int id) {
		String sql = "delete from " + TABLE_NAME + " where id=?";
		int result = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}

		return result;
	}

	@Override
	public int RowCount() {
		int rowcount = 0;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT COUNT(*) FROM " + TABLE_NAME);) {

			while (rset.next()) {
				rowcount = rset.getInt(1);
			}
		} catch (SQLException e) {
			throw new IllegalStateException("count 실패 " + e.getMessage());
		}
		return rowcount;
	}

	@Override
	public int deleteAll() {
		String sql = "delete from " + TABLE_NAME + " where id > 0";
		int result = 0;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33063/koposw44", "root", "koposw44");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}

		return result;
	}

}
