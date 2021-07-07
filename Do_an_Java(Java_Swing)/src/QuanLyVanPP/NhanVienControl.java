package QuanLyVanPP;

import java.sql.ResultSet;
import java.sql.SQLException;

import Object.NhanVien;

public class NhanVienControl {
	private NhanVienModel model;
	
	public NhanVienControl() {
		model=new NhanVienModel();
	}
	public int insertNhanVien (NhanVien std) {
		int cnt = 0;
		try {
			cnt = model.insert(std);
		}catch (Exception ex) {
			System.out.println("Error: "+ex.toString());
		}
		return cnt;
	}
	
	public int deleteNhanVien(NhanVien std){
		int cnt=0;
		try{
			cnt=model.delete(std);
		}catch (Exception ex){
			System.out.println("Error: "+ex.toString());
		}
		return cnt;
		}
	
	public int updateNhanVien(NhanVien std,  String MaNV){
		int cnt=0;
		try{
			cnt=model.update(std, MaNV);
		}catch (Exception ex){
			System.out.println("Error: "+ex.toString());
		}
		return cnt;
	}
//
	public ResultSet guiThongTinNhanVien() {
		ResultSet rs=null;
		try {
			rs = this.model.layThongTinNhanVien();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
