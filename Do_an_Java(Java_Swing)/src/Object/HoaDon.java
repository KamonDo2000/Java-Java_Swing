package Object;

public class HoaDon {
	String maHoaDon;
	String khach;
	String hang;
	String soLuong;
	int thanhTien;
	
	public HoaDon(String maHoaDon, String khach, String hang, String soLuong, int thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.khach = khach;
		this.hang = hang;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	
	public HoaDon() {
		this.maHoaDon = "";
		this.khach = "";
		this.hang = "";
		this.soLuong = "";
		this.thanhTien = 0;
	}

	public HoaDon(HoaDon hd) {
		super();
		this.maHoaDon = hd.maHoaDon;
		this.khach = hd.khach;
		this.hang = hd.hang;
		this.soLuong = hd.soLuong;
		this.thanhTien = hd.thanhTien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getKhach() {
		return khach;
	}

	public void setKhach(String khach) {
		this.khach = khach;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	
}
