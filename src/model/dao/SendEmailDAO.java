package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SendEmailDAO extends BaseDAO {

	public String SelectAccout(String accID) {
		
		Connection connection = getConnection();
		String sql = "Select * FROM NhanVien WHERE UserName = ? ";
		PreparedStatement pstmt = null;
		String Email = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, accID);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
								
				Email= rs.getString("Email");
				
				
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, null);
		}
		return Email;
	}

	

}
