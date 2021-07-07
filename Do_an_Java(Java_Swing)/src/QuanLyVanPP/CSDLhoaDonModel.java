package QuanLyVanPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.HoaDon;

public class CSDLhoaDonModel {
	
	private static Connection getConnection() throws SQLException{
		return	DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyvanphongpham","root","");
	}

	public ResultSet layThongTinHangHoa() throws SQLException {
		Connection cnn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			cnn=CSDLhoaDonModel.getConnection();
			ps=cnn.prepareStatement("SELECT * FROM hoadon");
			rs=ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
