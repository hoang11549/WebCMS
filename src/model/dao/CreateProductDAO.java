package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateProductDAO extends BaseDAO {

	public void insertProduct(String maHH, String tenHH, String dvt,
			String donGiaTK, String ghiChu) {
		Connection connection = getConnection();
		String sql = "INSERT INTO HANG_HOA (MaHH,TenHH,DonGiaThamKhao,DonViTinh"
			+ ",GhiChu) VALUES (?,?,?,?,?)";		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, maHH);
			pstmt.setString(2, tenHH);
			pstmt.setDouble(3, Double.valueOf(donGiaTK));
			pstmt.setString(4, dvt);
			pstmt.setString(5, ghiChu);
			
			int x = pstmt.executeUpdate();
			System.out.println("Đã chèn số record: " + x);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, null);
		}		
	}
}

