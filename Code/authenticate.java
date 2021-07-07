package vitcollegeworld;

import java.sql.*;
import java.util.*;
class authenticate {
	public static String reg_authicate="";
	public static boolean authenticate_users()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("### Welcome to Login Portal ###");
		try {
			System.out.println("Please Enter your Registration Number: ");
			reg_authicate = input.next();
			System.out.println("Please Enter your Password: ");
			String password_authenticate = input.next();
			if(reg_authicate.length()==9 && password_authenticate.equals("root"))
			{
				return true;
			}
			else
			{
				System.out.println("Invalid username or password");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Please Enter Correct Details");
		}
		return true;
	}
}
