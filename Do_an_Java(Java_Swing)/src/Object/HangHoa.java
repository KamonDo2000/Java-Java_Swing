package Object;

public class HangHoa {
	String idHang;
	String tenHang;
	String giaBan;
	String tonKho;
	String daBan;
	public HangHoa(String idHang, String tenHang, String giaBan, String tonKho, String daBan) {
		this.idHang = idHang;
		this.tenHang = tenHang;
		this.giaBan = giaBan;
		this.tonKho = tonKho;
		this.daBan = daBan;
	}
	
	public HangHoa() {
		this.idHang = "";
		this.tenHang = "";
		this.giaBan = "";
		this.tonKho = "";
		this.daBan = "";
	}

	public HangHoa(HangHoa hh) {
		super();
		this.idHang = hh.idHang;
		this.tenHang = hh.tenHang;
		this.giaBan = hh.giaBan;
		this.tonKho = hh.tonKho;
		this.daBan = hh.daBan;
	}

	public String getIdHang() {
		return idHang;
	}

	public void setIdHang(String idHang) {
		this.idHang = idHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}

	public String getTonKho() {
		return tonKho;
	}

	public void setTonKho(String tonKho) {
		this.tonKho = tonKho;
	}

	public String getDaBan() {
		return daBan;
	}

	public void setDaBan(String daBan) {
		this.daBan = daBan;
	}
	
}
