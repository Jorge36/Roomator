package ie.cct.Roomator;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000",  methods = {RequestMethod.POST, RequestMethod.GET})
@RestController
public class Controller {
	
	private ArrayList<User> users;
	
	// construct which create an Array List to save the users in runtime
	public Controller() {
		super();
		this.users = new ArrayList<User>();
				
		User user = new User("Jhon", "123","jhon@gmail.com", true, 30, new String[]{ "Swimming","Music","Football"}, new Location("place", 53.334240, -6.276652));
		this.users.add(user);
		user = new User("Paul", "123","paul@gmail.com", true, 39, new String[]{ "Swimming","Music","Basketball"}, new Location("place", 53.340270, -6.272631));
		this.users.add(user);
		user = new User("Mark", "123","mark@hotmail.com", true, 29, new String[]{ "Swimming","Cinema","Playing guitar"}, new Location("place", 53.343213, -6.281089)); 
		this.users.add(user);
		user = new User("Jim", "123","jim@yahooo.com", true, 35, new String[]{ "Football","Cinema","Playing guitar"}, new Location("place", 53.345105, -6.276076)); 
		this.users.add(user);
		
	}

	// Login which return a boolean value, the input is a class which has an email, a password and a location 
	@PostMapping("login") 
	public Boolean login(@RequestBody LoginRequest userLogin) {
				 
		EmailCompare emailCompare = new EmailCompare();
		
		Collections.sort(users, emailCompare);
						
		User user = new User(userLogin.getEmail(), userLogin.getPassword());
		
		int index = Collections.binarySearch(users, user ,emailCompare);
		
		if (index >= 0) {
			
			if (user.getPassword().equalsIgnoreCase(users.get(index).getPassword())) {  
				
				return true;
				
					
			} else {
				// the password is different the user is not authorized
				throw new UnauthorizedException();
			}
			
		}
		else return false; // the email doesn't exist
		
	}
		
	@GetMapping("user")
	public User getUser(@RequestHeader("email") String email) {
		
		EmailCompare emailCompare = new EmailCompare();
		
		Collections.sort(users, emailCompare);
		
		User user = new User(email);
		
		int index = Collections.binarySearch(users, user , emailCompare);
		
		if (index >= 0) {
			
			return users.get(index);
			
		} else return null;
		
	}


	@PostMapping("register")
	public Boolean Register(@RequestBody User user) {
		
		EmailCompare emailCompare = new EmailCompare();

		Collections.sort(users, emailCompare);
				
		int index = Collections.binarySearch(users, user, emailCompare);
	
		if (index < 0) {
						
			users.add(user);
			
			return true;
			
		}
		return false;
			
	}

	@PostMapping("searchRoomate") 
	public ArrayList<User> searchRoomMates(@RequestBody Location location, @RequestHeader("email") String email, @RequestHeader("distance") Double distance, @RequestHeader(value = "smoker", required = false) Boolean smoker, @RequestHeader(value = "diffAge") Integer diffAge)  {
		
		EmailCompare emailCompare = new EmailCompare();
		
		Collections.sort(this.users, emailCompare);
						
		User userSearch = new User(email, "");
		
		int index = Collections.binarySearch(this.users, userSearch ,emailCompare);
		
		if (index >= 0) {
		
			ArrayList<User> users = new ArrayList<>();
			
			Double currentDistance;
			
			for (User user: this.users) {
				
				if (user.getEmail().equalsIgnoreCase(email))
					continue;
				
				if (Math.abs(user.getAge() - this.users.get(index).getAge()) > diffAge)
						continue;
				
				if (smoker != null)
					if (user.getSmoker().compareTo(smoker) != 0)
						continue;
				
				currentDistance = location.distanceTo(user.getLocation());
				
				if (currentDistance <= distance) {
					user.setDistance(currentDistance);
					users.add(user);
				}
				
			}
			
			return users;
			
		} else return null;		
	}

		
}
