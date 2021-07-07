package QuanLyVanPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.HangHoa;

public class HangHoaModel {
	
	private static Connection getConnection() throws SQLException{
		return	DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyvanphongpham","root","");
	}
	
	public int insert(HangHoa macHang) throws SQLException {
/*nay*/		if(macHang.getTenHang().equals("")|| macHang.getGiaBan().equals("")|| macHang.getTonKho().equals("")|| macHang.getDaBan().equals(""))
			return 2;
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			con = this.getConnection();
			ps = con.prepareStatement("insert into hanghoa value (?, ?, ?, ?, ?)");
			ps.setString(1, macHang.getIdHang());
			ps.setString(2, macHang.getTenHang());
			ps.setString(3, macHang.getGiaBan());
			ps.setString(4, macHang.getTonKho());
			ps.setString(5, macHang.getDaBan());
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

	public int delete(String idHang) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			con = this.getConnection();
			ps = con.prepareStatement("delete from hanghoa where idHang=?");
			ps.setString(1, idHang);	
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

	public int update(HangHoa macHang, String idHang) throws SQLException{
		if(macHang.getTenHang().equals("")|| macHang.getGiaBan().equals("")|| macHang.getTonKho().equals("")|| macHang.getDaBan().equals(""))
			return 2;
		if(!macHang.getIdHang().equals(idHang))
			return 0;
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			con = this.getConnection();
			ps = con.prepareStatement("update hanghoa set tenHang=?, giaBan=?, tonKho=?, daBan=? where idHang=? ");
			ps.setString(5, idHang);
			ps.setString(1, macHang.getTenHang());
			ps.setString(2, macHang.getGiaBan());
			ps.setString(3, macHang.getTonKho());
			ps.setString(4, macHang.getDaBan());
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
	//table
	public ResultSet layThongTinHangHoa() throws SQLException {
		Connection cnn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			cnn=HangHoaModel.getConnection();
			ps=cnn.prepareStatement("SELECT * FROM hanghoa");
			rs=ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
