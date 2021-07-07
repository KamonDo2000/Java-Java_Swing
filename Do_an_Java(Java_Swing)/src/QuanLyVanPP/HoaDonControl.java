package QuanLyVanPP;

import java.sql.ResultSet;
import java.sql.SQLException;

import Object.HoaDon;

public class HoaDonControl {
public HoaDonModel model = new HoaDonModel();

	public int insertHoaDon(HoaDon hoaDon, String maHang) {
		int cnt = 0;
		try {
			cnt = model.insert(hoaDon, maHang);
		}catch(SQLException ex) {
			System.err.print("Err: " + ex.toString());
		}
		return cnt;
	}
	
	public int deleteHoaDon(String maHoaDon) {
		int cnt = 0;
		try {
			cnt = model.delete(maHoaDon);
		} catch (Exception e) {
			System.err.print("Err: " + e.toString());
		}
		return cnt;
	}
//
	public ResultSet guiThongTinHoaDon(String maHoaDon) {
		ResultSet rs=null;
		try {
			rs = this.model.layThongTinHoaDon(maHoaDon);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
