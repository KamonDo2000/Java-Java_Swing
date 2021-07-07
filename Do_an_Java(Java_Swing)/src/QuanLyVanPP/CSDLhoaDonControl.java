package QuanLyVanPP;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.HoaDon;

public class CSDLhoaDonControl {
	public CSDLhoaDonModel model = new CSDLhoaDonModel();
	
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
