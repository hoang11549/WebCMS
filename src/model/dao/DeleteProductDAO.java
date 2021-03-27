package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class DeleteProductDAO extends BaseDAO {
	public void deleteProduct(String proId) {
		Connection connection = getConnection();
		String sql = "DELETE FROM HANG_HOA WHERE mahh =?";
		PreparedStatement pstmt = null;
	
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, proId);
			int x =pstmt.executeUpdate();
			System.out.println(" da xoa so record: "+ x);
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, null);
		}
		
		
		

	}

}
