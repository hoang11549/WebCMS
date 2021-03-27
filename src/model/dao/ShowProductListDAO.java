package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.HangHoa;
public class ShowProductListDAO extends BaseDAO  {
public ArrayList<HangHoa> getDsHangHoa(){
	ArrayList<HangHoa> returnedList = new ArrayList<HangHoa>();
			Connection connection = getConnection();
	String sql = "SELECT * FROM HANG_HOA";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = connection.prepareStatement(sql);	
		rs = pstmt.executeQuery();
		HangHoa item = null;
		while(rs.next()) {
			item = new HangHoa();
			item.setMaHH(rs.getString("mahh"));
			item.setTenHH(rs.getString("tenhh"));
			item.setDonGiaThamKhao(rs.getDouble("dongiathamkhao"));
			item.setDonViTinh(rs.getString("donvitinh"));
			item.setGhiChu(rs.getString("ghichu"));
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
