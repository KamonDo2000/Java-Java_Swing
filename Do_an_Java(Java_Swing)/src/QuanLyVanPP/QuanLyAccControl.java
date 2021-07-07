package QuanLyVanPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Admin;

public class QuanLyAccControl {
private QuanLyAccModel quanLyAccModel;
	
	public QuanLyAccControl() {
		this.quanLyAccModel = new QuanLyAccModel();
	}
	
	public int checkpass(Admin admin) {
		int check=0;
		try {
			if (this.quanLyAccModel.confirmMeThod(admin)==1)
				return 1;
			if(this.quanLyAccModel.confirmMeThod(admin)==3)
				return 3;
			if(this.quanLyAccModel.confirmMeThod(admin)==2)
				return 2;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
}
