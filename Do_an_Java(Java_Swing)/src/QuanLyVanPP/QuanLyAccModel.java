package QuanLyVanPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Admin;

public class QuanLyAccModel {
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyvanphongpham", "root", "");
	}
	
	public int confirmMeThod(Admin admin) throws SQLException {
		String QT = "0";
		String NV = "1";
		if(admin.getUserName().equals("")|| admin.getPassWorld().equals(""))
			return 3;
		
		Connection cnt = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			cnt=QuanLyAccModel.getConnection();
			ps=cnt.prepareStatement("SELECT * FROM dangnhap WHERE UserName=? AND PassWorld=?");
			ps.setString(1, admin.getUserName());
			ps.setString(2, admin.getPassWorld());
			rs = ps.executeQuery();
			String userName = null;
			String passWorld = null;
			String use = null;
			while(rs.next()) {
				userName = rs.getString(1);
				passWorld = rs.getString(2);
				use = rs.getString("use");
			} 
			if(admin.getUserName().equals(userName) && admin.getPassWorld().equals(passWorld) && NV.equals(use))
				return 2;
			if(admin.getUserName().equals(userName) && admin.getPassWorld().equals(passWorld) && QT.equals(use))
				return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (cnt!=null)
				cnt.close();
			if(ps!=null)
				ps.close();
			if(rs!=null)
				rs.close();
		}
		return 0;
	}
	
}
