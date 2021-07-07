package QuanLyVanPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Admin;

public class DoiMKModel {
	
	private static Connection getConnection() throws SQLException{
		return	DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyvanphongpham","root","");
	}
	
	public int insert(Admin admin) throws SQLException {
/*nay*/		if(admin.getUserName().equals("")|| admin.getPassWorld().equals("")|| admin.getUse().equals(""))
			return 2;
			if(!admin.getUse().equals("1") && !admin.getUse().equals("0"))
				return 3;
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			con = this.getConnection();
			ps = con.prepareStatement("insert into dangnhap value (?, ?, ?)");
			ps.setString(1, admin.getUserName());
			ps.setString(2, admin.getPassWorld());
			ps.setString(3, admin.getUse());
			cnt=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null)
				ps.close();
			if(con != null)
				con.close();
		}
		return cnt;
	}

	public int delete(String username, String passworld) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			con = this.getConnection();
			ps = con.prepareStatement("delete from dangnhap where UserName=? and PassWorld=?");
			ps.setString(1, username);	
			ps.setString(2, passworld);	
			cnt=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null)
				ps.close();
			if(con != null)
				con.close();
		}
		return cnt;
	}

	public int update(Admin admin, String username) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		
		if(admin.getUserName().equals("")|| admin.getPassWorld().equals(""))
			return 2;
		if(!admin.getUserName().equals(username))
			return 0;
		
		try {
			con = this.getConnection();
			ps = con.prepareStatement("Update dangnhap set PassWorld=? where UserName=?");
			ps.setString(2, username);
			ps.setString(1, admin.getPassWorld());
			cnt=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null)
				ps.close();
			if(con != null)
				con.close();
		}
		return cnt;
	}
	
}
