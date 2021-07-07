package Object;

public class NhanVien extends Person {
	protected String MaNV;
	protected String salary;
	protected String time;

	public NhanVien(NhanVien nv) {
		super(nv.name, nv.age, nv.address, nv.gender);
		this.MaNV= nv.MaNV;
		this.salary= nv.salary;
		this.time = nv.time;
	}
	public NhanVien() {
		super();
		this.MaNV = "";
		this.salary = "";
		this.time = "";
	}
	public NhanVien(String MaNV, String name, String age, String address, String gender, String phone, String salary, String time){
		this.MaNV = MaNV;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
		this.salary = salary;
		this.time = time;
	}
	
	public String getMaNV() {
		return this.MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getSalary() {
		return this.salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getTime() {
		return this.time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
