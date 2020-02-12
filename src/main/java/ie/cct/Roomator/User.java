package ie.cct.Roomator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class User {

	private String userName;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String email;
	private Boolean smoker;
	private Integer age;
	private String[] hobbies;
	private Location location;
	private Double distance;
		
	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getSmoker() {
		return smoker;
	}

	public void setSmoker(Boolean smoker) {
		this.smoker = smoker;
	}

	public User() {
	}
	
	
	public User(String email) {
		super();
		this.email = email;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String userName, String password, String email, Boolean smoker, Integer age, String[] hobbies,
			Location location) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.smoker = smoker;
		this.age = age;
		this.hobbies = hobbies;
		this.location = location;
	}

	
	
	
}
