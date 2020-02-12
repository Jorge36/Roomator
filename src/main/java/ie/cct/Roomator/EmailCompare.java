package ie.cct.Roomator;

import java.util.Comparator;

public class EmailCompare implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
		
		if (stringCompare(user1.getEmail(), user2.getEmail()) > 0)
			return 1;
		if (stringCompare(user1.getEmail(), user2.getEmail()) < 0)
			return -1;
		else return 0; 
			
	}
	
	private int stringCompare(String str1, String str2) 
    { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
  
        if (l1 != l2)
            return l1 - l2; 
        else  
            return 0; 
    }
        
}
