import java.util.Scanner;
import java.io.*;



@SuppressWarnings("unused")
class WiFiDiagnosis {
    public static void main(String[] args)
    {
		Scanner inputGet = new Scanner(System.in);
        String ans;
    	
        System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work..\nFirst step: reboot your computer\nAre you able to connect to the internet?");
        ans = inputGet.nextLine();
        if(ans.equals("Y")) {
        	System.out.println("Rebooting the computer seemed to work");
        	System.exit(0);
        	
        } else {
        	System.out.println("Second step: reboot your router\nNow are you able to connect to the internet?");
        	ans = inputGet.nextLine();
        	if (ans.equals("Y")) {
        		System.out.println("Rebooting your router seemed to work");
        		System.exit(0);
        		
        	} else {
        		System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power\nNow are you able to connect to the internet?");
        		ans = inputGet.nextLine();
        		if(ans.equals("Y")) {
        			System.out.println("Checking the router's cables seemed to work.");
        			System.exit(0);
        			
        		} else {
        			 System.out.println("Fourth step: move your computer closer to your router\nNow are you able to connect to the internet?");
        			 ans = inputGet.nextLine();
        			 if(ans.equals("Y")) {
        				 System.out.println("Moving the computer closer to your router seemed to work.");
        				 System.exit(0);
        				
        			 } else {
        				 System.out.println("Fifth step: contact your ISP\nMake sure your ISP is hooked up to your router.");
        				 System.exit(0);
        				 inputGet.close();
        			 }
        			 
        		}
        			
        	}
        	
        }
        
    }
   
}