package QuanLyVanPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.HoaDon;

public class HoaDonModel {
	
	private static Connection getConnection() throws SQLException{
		return	DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyvanphongpham","root","");
	}

	public int layThongTinGiaBan(HoaDon hoaDon, String maHang) throws SQLException {
		Connection con = null;
		ResultSet rs=null;
		PreparedStatement ps = null;
		int cnt = 0;
		int thanhtienn = 0;
	try {
		con=HoaDonModel.getConnection();
		ps=con.prepareStatement("SELECT giaBan FROM hanghoa where idHang=?");
		ps.setString(1, maHang);	
		rs=ps.executeQuery();
		String gia = null;
		while(rs.next()) {
			gia = rs.getString(1);
			}
		 thanhtienn = Integer.parseInt(gia)*Integer.parseInt(hoaDon.getSoLuong());
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		if (con!=null)
			con.close();
		if(ps!=null)
			ps.close();
		if(rs!=null)
			rs.close();
	}
	return thanhtienn;
	}
	
	public int insert(HoaDon hoaDon, String maHang) throws SQLException {
		if(hoaDon.getMaHoaDon().equals("")|| hoaDon.getKhach().equals("")|| hoaDon.getHang().equals("")|| hoaDon.getSoLuong().equals(""))
			return 2;
		if(layThongTinGiaBan(hoaDon, maHang) == 0)
			return 3;
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			con = this.getConnection();
			ps = con.prepareStatement("insert into hoadon value (?, ?, ?, ?, ?)");
			ps.setString(1, hoaDon.getMaHoaDon());
			ps.setString(2, hoaDon.getKhach());
			ps.setString(3, hoaDon.getHang());
			ps.setString(4, hoaDon.getSoLuong());
			ps.setInt(5, layThongTinGiaBan(hoaDon, maHang));
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

	public int delete(String maHoaDon) throws SQLException{
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			con = this.getConnection();
			ps = con.prepareStatement("delete from hoadon where maHoaDon=?");
			ps.setString(1, maHoaDon);	
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
//
	public ResultSet layThongTinHoaDon(String maHoaDon) throws SQLException {
//		if(maHoaDon.equals(""))
//			return null;
		Connection cnn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			cnn=HoaDonModel.getConnection();
			ps=cnn.prepareStatement("SELECT * FROM hoadon where maHoaDon=?");
			ps.setString(1, maHoaDon);
			rs=ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
