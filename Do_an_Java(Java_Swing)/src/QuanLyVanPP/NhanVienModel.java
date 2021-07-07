package QuanLyVanPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.NhanVien;

public class NhanVienModel {
	private static Connection getConnection() throws SQLException{
		return	
				DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlyvanphongpham", "root", "");
	}
	public int insert(NhanVien std) throws SQLException{
		if(std.getName().equals("")|| std.getAge().equals("")|| std.getGender().equals("")|| std.getAddress().equals("")|| std.getPhone().equals("")|| std.getSalary().equals("")|| std.getTime().equals(""))
			return 2;
		Connection cnn = null;
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			cnn = this.getConnection();
			ps = cnn.prepareStatement("insert into nhanvien value (?,?,?,?,?,?,?,?)");
			ps.setString(1, std.getMaNV());
			ps.setString(2, std.getName());
			ps.setString(3, std.getAge());
			ps.setString(4, std.getGender());
			ps.setString(5, std.getAddress());
			ps.setString(6, std.getPhone());
			ps.setString(7, std.getSalary());
			ps.setString(8, std.getTime());
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
	public int delete(NhanVien std) throws SQLException{
		Connection cnn=null;
		PreparedStatement ps=null;
		int cnt=0;
		try{
			cnn=this.getConnection();
			ps=cnn.prepareStatement("Delete from NhanVien where MaNV=?");
			ps.setString(1,std.getMaNV());
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
	
	public int update(NhanVien std, String MaNV) throws SQLException{
		if(std.getName().equals("")|| std.getAge().equals("")|| std.getGender().equals("")|| std.getAddress().equals("")|| std.getPhone().equals("")|| std.getSalary().equals("")|| std.getTime().equals(""))
			return 2;
		if(!std.getMaNV().equals(MaNV))
			return 0;
		Connection cnn=null;
		PreparedStatement ps=null;
		int cnt=0;
		try{
			cnn=this.getConnection();
			ps=cnn.prepareStatement("Update nhanvien set Name=?, Age=?, Gender=?, Address=?, Phone=?, Salary=?, Time=? where MaNV=? ");
			ps.setString(8, MaNV);
			ps.setString(1, std.getName());
			ps.setString(2, std.getAge());
			ps.setString(3, std.getGender());
			ps.setString(4, std.getAddress());
			ps.setString(5, std.getPhone());
			ps.setString(6, std.getSalary());
			ps.setString(7, std.getTime());
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
//
	public ResultSet layThongTinNhanVien() throws SQLException {
		Connection cnn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			cnn=NhanVienModel.getConnection();
			ps=cnn.prepareStatement("SELECT * FROM nhanvien");
			rs=ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
	
