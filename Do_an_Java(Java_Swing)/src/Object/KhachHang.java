package Object;

public class KhachHang extends Person
{
	protected String MaKH;
	
	public KhachHang() {
		super();
		this.MaKH = "";
	}
	
	public KhachHang(KhachHang nv) {
		super(nv.name, nv.age, nv.address, nv.gender);
		this.MaKH= nv.MaKH;
	}
	
	public KhachHang(String MaKH, String name, String age, String address, String gender, String phone){
		this.MaKH = MaKH;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
	}
	
	public KhachHang(String MaKH) {
		this.MaKH = MaKH;
	}
	public String getMaKH() {
		return this.MaKH;
	}
	public void setMaKH(String MaKH) {
		this.MaKH = MaKH;
	}
}