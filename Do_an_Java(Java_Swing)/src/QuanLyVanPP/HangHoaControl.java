package QuanLyVanPP;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.HangHoa;

public class HangHoaControl {
	public HangHoaModel model = new HangHoaModel();
	
	public int insertHangHoa(HangHoa machang) {
		int cnt = 0;
		try {
			cnt = model.insert(machang);
		}catch(SQLException ex) {
			System.err.print("Err: " + ex.toString());
		}
		return cnt;
	}
	
	public int deleteHangHoa(String idHangHoa) {
		int cnt = 0;
		try {
			cnt = model.delete(idHangHoa);
		} catch (Exception e) {
			System.err.print("Err: " + e.toString());
		}
		return cnt;
	}

	public int updateHangHoa(HangHoa machang, String idHangHoa)
	{
		int cnt=0;
		try {
			cnt = model.update(machang, idHangHoa);
		} catch (Exception e) {
			System.err.println("ERROR"+e.toString());
		}
		return cnt;
	}
	//table
	public ResultSet guiThongTinHangHoa() {
		ResultSet rs=null;
		try {
			rs = this.model.layThongTinHangHoa();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
