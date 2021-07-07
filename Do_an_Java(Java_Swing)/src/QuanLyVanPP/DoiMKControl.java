package QuanLyVanPP;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Admin;

public class DoiMKControl {
	public DoiMKModel model = new DoiMKModel();
	
	public int insertMK(Admin admin) {
		int cnt = 0;
		try {
			cnt = model.insert(admin);
		}catch(SQLException ex) {
			System.err.print("Err: " + ex.toString());
		}
		return cnt;
	}
	
	public int deleteMK(String username, String passworld) {
		int cnt = 0;
		try {
			cnt = model.delete(username, passworld);
		} catch (Exception e) {
			System.err.print("Err: " + e.toString());
		}
		return cnt;
	}

	public int updateMK(Admin admin, String username)
	{
		int cnt=0;
		try {
			cnt = model.update(admin, username);
		} catch (Exception e) {
			System.err.println("ERROR"+e.toString());
		}
		return cnt;
	}
}
