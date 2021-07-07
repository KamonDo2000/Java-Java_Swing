package QuanLyVanPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.KhachHang;
import Object.NhanVien;

	public class KhachHangModel {
		private static Connection getConnection() throws SQLException{
			return	
					DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyvanphongpham", "root", "");
		}
		public int insert(KhachHang std) throws SQLException{
			if(std.getName().equals("")|| std.getAge().equals("")|| std.getGender().equals("")|| std.getAddress().equals("")|| std.getPhone().equals(""))
				return 2;
			Connection cnn = null;
			PreparedStatement ps = null;
			int cnt = 0;
			try {
				cnn = this.getConnection();
				ps = cnn.prepareStatement("insert into khachhang value (?,?,?,?,?,?)");
				ps.setString(1, std.getMaKH());
				ps.setString(2, std.getName());
				ps.setString(3, std.getAge());
				ps.setString(4, std.getGender());
				ps.setString(5, std.getAddress());
				ps.setString(6, std.getPhone());
				cnt=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null)
				ps.close();
			if(cnn != null)
				cnn.close();
		}
		return cnt;
	}
	
		public int delete(KhachHang std) throws SQLException{
			Connection cnn=null;
			PreparedStatement ps=null;
			int cnt=0;
			try{
				cnn=this.getConnection();
				ps=cnn.prepareStatement("Delete from KhachHang where MaKH=?");
				ps.setString(1,std.getMaKH());
				cnt=ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
				
			}finally{
				if(ps!=null){
					ps.close();
					}
				if(cnn!=null){
					cnn.close();
				}
			}
			return cnt;
		}
	
	public int update(KhachHang std, String MaKH) throws SQLException{
		if(std.getName().equals("")|| std.getAge().equals("")|| std.getGender().equals("")|| std.getAddress().equals("")|| std.getPhone().equals(""))
			return 2;
		if(!std.getMaKH().equals(MaKH))
			return 0;
		
		Connection cnn=null;
		PreparedStatement ps=null;
		int cnt=0;
		try{
			cnn=this.getConnection();
			ps=cnn.prepareStatement("Update khachhang set Name=?, Age=?, Gender=?, Address=?, Phone=? where MaKH=?");
			ps.setString(6, MaKH);
			ps.setString(1, std.getName());
			ps.setString(2, std.getAge());
			ps.setString(3, std.getGender());
			ps.setString(4, std.getAddress());
			ps.setString(5, std.getPhone());
			cnt=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ps!=null){
				ps.close();
				}
			if(cnn!=null){
				cnn.close();
			}
		}
		return cnt;
	}
	
	public ResultSet layThongTinKhachHang() throws SQLException {
		Connection cnn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			cnn=KhachHangModel.getConnection();
			ps=cnn.prepareStatement("SELECT * FROM khachhang");
			rs=ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
	
