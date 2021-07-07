package Object;

public class Person {
	protected String name;
	protected String age;
	protected String address;
	protected String gender;
	protected String phone;
	
	public Person() {
		this.name = "";
		this.address = "";
		this.gender = "";
		this.phone = "";
	}
	
	public Person( String name, String address, String gender, String phone) {
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
	}
	
	public Person ( Person person) {
		this.name =person.name;
		this.address = person.address;
		this.gender = person.gender;
		this.phone = person.phone;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return this.age;
	}
	public void setAge(String string) {
		this.age = string;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
