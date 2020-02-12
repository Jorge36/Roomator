package ie.cct.Roomator;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank
	private String email;

	@NotBlank
	private String password;
	
	private Location location;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	

}
