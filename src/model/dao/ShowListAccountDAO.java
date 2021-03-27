package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Accounts;

public class ShowListAccountDAO extends BaseDAO {

	public ArrayList<Accounts> getdsAccount() {
		// TODO Auto-generated method stub
		ArrayList<Accounts> returnedList = new ArrayList<Accounts>();
		Connection connection = getConnection();
String sql = "SELECT * FROM NhanVien";
PreparedStatement pstmt = null;
ResultSet rs = null;
try {
	pstmt = connection.prepareStatement(sql);	
	rs = pstmt.executeQuery();
	Accounts item = null;
	while(rs.next()) {
		item = new Accounts();
		item.setUserName(rs.getString("UserName"));
		item.setPassword(rs.getString("Password"));
		item.setEmail(rs.getString("Email"));
		
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
