
package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Comment;
import model.bean.HangHoa;
public class showListCommentDAO extends BaseDAO  {
public ArrayList<Comment> getListComment(String proId){
	
	ArrayList<Comment> returnedList = new ArrayList<Comment>();
			Connection connection = getConnection();
	String sql = "SELECT * FROM Comments WHERE MAHH =?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, proId);
		rs = pstmt.executeQuery();
		
		Comment item = null;
		while(rs.next()) {
			item = new Comment();
			item.setIDcomment(rs.getString("IDcomment"));
			item.setContentComment(rs.getString("ContentComment"));
			item.setnameAccount(rs.getString("nameAccount"));	
			returnedList.add(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		closeConnection(connection, pstmt, rs);
	}
	
	return returnedList; // invalid account
}
public String getDateTime(String proId) {
	Connection connection = getConnection();
	String date = null;
	String sql = "SELECT Date_time FROM HANG_HOA WHERE MAHH =?";
	PreparedStatement pstmt = null;
	
	ResultSet rs = null;
	try {
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, proId);
		rs = pstmt.executeQuery();
		
		
			if (rs.next()) {
				date = rs.getString("Date_time");
							} 
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
									}

		
	finally {
		closeConnection(connection, pstmt, rs);
			}
	return date;
}

public void BlockComment(String proId) {
	Connection connection = getConnection();
	String sql = "UPDATE HANG_HOA SET StatusComment = 0 WHERE MAHH= ?";
	// TODO Auto-generated method stub
	PreparedStatement pstmt = null;

	try {
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, proId);
		pstmt.executeQuery();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
}
public ArrayList<HangHoa> GetDetailHangHoa(String proId){
	
	ArrayList<HangHoa> returnedList = new ArrayList<HangHoa>();
			Connection connection = getConnection();
	String sql = "SELECT * FROM HANG_HOA WHERE MAHH = ?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, proId);
		rs = pstmt.executeQuery();	
		HangHoa item = null;
		while(rs.next()) {
			item = new HangHoa();
			item.setMaHH(rs.getString("MAHH"));
			item.setTenHH(rs.getString("TenHH"));
			item.setStatusComment(rs.getBoolean("StatusComment"));	
			returnedList.add(item);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		closeConnection(connection, pstmt, rs);
	}
	
	return returnedList; // invalid account
}
}
