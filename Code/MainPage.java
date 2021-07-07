package vitcollegeworld;

/***
 * @author Ishant Garg
 * This project aiming towards College World of VIT.
 * With the help of this project, you can find resources, faculty info,
 * register new faculty, Cab sharing information.
 * 
 * Mainly, faculty details is registered only by admin of College
 * but, The aim of the project not to break the policy rules, only try
 * to implement a sample, How to register new person.
 * 
 *  Database used in MySql and all entries are checked and registered in SQL.
 *  
 *  Future Works:
 *  1. We can also add new features like Information about Food Courts,
 *  	Details about college games functions, FEST functions and many more.
 *  2. We can also apply constraints on registration number of registered student
 *  	and Faculty Info Showing as per College Regulations and Policies
 *  and the list is going on.. According to the College preference.
 */


import vitcollegeworld.*;
import java.util.*;
public class MainPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("||||||  Welcome to VIT COLLEGE WORLD |||||\n\n\n");
		
		//Authenticate the user
		authenticate auth1 = new authenticate();
		boolean temp=true;
		while(temp && (auth1.authenticate_users()))
		{
		
		System.out.println("Choose Appropriate options: ");
		Scanner input=new Scanner(System.in);
		try {
		System.out.println("\n1. Resources\n2. Faculty Info\n3. Cab share\n4. EXIT");
		int main_menu_option = input.nextInt();
		while(main_menu_option>=1 && main_menu_option<=3)
		{
			if(main_menu_option == 1)
			{
				Resources res1 = new Resources();
				res1.resources();
			}
			else if(main_menu_option == 2)
			{
				faculty f1 = new faculty();
				f1.faculty_registration();
			}
			else if(main_menu_option == 3)
			{
				cabshare cs1=new cabshare();
				cs1.cab_share_program();
			}
			System.out.println("Choose Appropriate options: ");
			System.out.println("\n1. Resources\n2. Faculty Info\n3. Cab share\n4. EXIT");
			main_menu_option = input.nextInt();
		}
		}
		catch(Exception e)
		{
			System.out.println("Please Enter Correct Values");
		}
		System.out.println("If you want to go again! Please Enter 1 otherwise 0");
		int input_main_menu_checking = input.nextInt();
		if(input_main_menu_checking==-1)
		{
			temp=false;
			System.out.println("Thank You! You have Successfully EXIT");
		}
	}
	}

}
