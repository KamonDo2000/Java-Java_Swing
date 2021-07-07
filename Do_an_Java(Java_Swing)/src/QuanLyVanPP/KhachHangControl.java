package QuanLyVanPP;

import java.sql.ResultSet;
import java.sql.SQLException;

import Object.KhachHang;
import Object.NhanVien;

public class KhachHangControl {
	private KhachHangModel model;
	
	public KhachHangControl() {
		model=new KhachHangModel();
	}
	public int insertKhachHang (KhachHang std) {
		int cnt = 0;
		try {
			cnt = model.insert(std);
		}catch (Exception ex) {
			System.out.println("Error: "+ex.toString());
		}
		return cnt;
	}
	
	public int deleteKhachHang(KhachHang std){
		int cnt=0;
		try{
			cnt=model.delete(std);
		}catch (Exception ex){
			System.out.println("Error: "+ex.toString());
		}
		return cnt;
		}
	
	public int updateKhachHang(KhachHang std, String MaKH){
		int cnt=0;
		try{
			cnt=model.update(std, MaKH);
		}catch (Exception ex){
			System.out.println("Error: "+ex.toString());
		}
		return cnt;
	}
	
	public ResultSet guiThongTinKhachHang() {
		ResultSet rs=null;
		try {
			rs = this.model.layThongTinKhachHang();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
