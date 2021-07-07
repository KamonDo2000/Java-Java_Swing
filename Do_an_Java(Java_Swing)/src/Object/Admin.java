package Object;

public class Admin {
	private String userName;
	private String passWorld;
	private String use;
	
	public void Admin() {}

	public void Admin(String userName, String passWorld) {
		this.userName = userName;
		this.passWorld = passWorld;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWorld() {
		return passWorld;
	}

	public void setPassWorld(String passWorld) {
		this.passWorld = passWorld;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	};
	
	
}
