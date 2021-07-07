package vitcollegeworld;

import java.sql.*;
import java.util.*;
import vitcollegeworld.*;
class cabshare {

	public static void cab_share_program() {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Welcome to cab share portal\nHere you can find out sharing cabs,"
				+ " that are registered by your college students for sharing purpose.");
		System.out.println("Please Choose Appropriate options: ");
		System.out.println("\n1. Register for cab\n2. Delete Registered details of cab share"
				+ "\n3. Searching Cab..\n4. EXIT");
		int option_cab_share=input.nextInt();
		System.out.println("\n!!!Please Enter all inputs with underscore in place of space!!!");
		
		String url="jdbc:mysql://localhost:3306/vit_college";
		String uname="root";
		String pass="root";
		Connection conn=null;
		String registration_number = authenticate.reg_authicate;
		while(option_cab_share>=1 && option_cab_share<=3)
		{
			if(option_cab_share == 1)
			{
				try {
				System.out.println("Please Enter Starting point: ");
				String start_cab_share=input.next();
				System.out.println("Please Enter Destination Point: ");
				String destination_cab_share = input.next();
				System.out.println("Please Enter how many seats remaining: ");
				int seats_rem_cab_share = input.nextInt();
				System.out.println("Please Enter how much charge per seat: ");
				int seats_charge_cab_share = input.nextInt();
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection(url, uname, pass);
				}
				catch(Exception e)
				{
					System.out.println("There is Connection Problem");
				}
				if(registration_number.length()==9 && start_cab_share.length()>0
						&& destination_cab_share.length()>0 && seats_rem_cab_share>0 
						&& seats_charge_cab_share>=0
						&& start_cab_share.equals(destination_cab_share)==false)
				{
					String query="insert into cab_share values(?,?,?,?,?)";
					PreparedStatement st=conn.prepareStatement(query);
					st.setString(1, registration_number);
					st.setString(2, start_cab_share);
					st.setString(3, destination_cab_share);
					st.setInt(4, seats_rem_cab_share);
					st.setInt(5, seats_charge_cab_share);
					st.executeUpdate();
					System.out.println("Your details are submitted successfully!!");
				}
				
				}
				catch(Exception e)
				{
					System.out.println("Please Enter Appropriate values");
				}
			}
			else if(option_cab_share == 2)
			{
				try
				{
					String query="delete from cab_share where reg_no=?";
					PreparedStatement st=conn.prepareStatement(query);
					st.setString(1, registration_number);
					
					int i=st.executeUpdate();
					if(i>0)
					{
						System.out.println("Your details are deleted successfully from cab share portal");
					}
					else
					{
						System.out.println("There is no record found registered by you");
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
					//System.out.println("Sorry!! There is problem in connection");
				}
			}
			else if(option_cab_share == 3)
			{
				System.out.println("Welcome to search portal of cab share"
						+ "of VIT College World");
				System.out.println("Please Enter all details with underscore in place of space");
				try {
					System.out.println("Please Enter Starting point: ");
					String start_search_cab_share = input.next();
					System.out.println("Please Enter Destination point: ");
					String desti_search_cab_share = input.next();
					if(start_search_cab_share.length()>0 && desti_search_cab_share.length()>0)
					{
						try
						{
							String query="select reg_no,seats_remaining,charge_per_seat from cab_share where starting_point=? AND destination=?";
							PreparedStatement st1=conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
							st1.setString(1, start_search_cab_share);
							st1.setString(2, desti_search_cab_share);
							
							ResultSet rs= st1.executeQuery();
							if(rs.next()==false)
							{
								System.out.println("Sorry!! There are no cabs available");
							}
							else
							{
								rs.previous();
								int count=0;
								while(rs.next())
								{
									System.out.println("Details of cab"+(count+1)+" are: ");
									System.out.println("Registration Number of sharing person: "+rs.getString(1));
									System.out.println("Remaining seats are: "+rs.getString(2));
									System.out.println("Charge per seat is: "+rs.getString(3));
									System.out.println("Please Contact him ASAP. Thank You!!");
								}
							}
						}
						catch(Exception e)
						{
							System.out.println("There might be connection problem\nSorry for Inconvience\n\n");
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please Enter appropriate details");
				}
			}
			System.out.println("Please Choose Appropriate options: ");
			System.out.println("\n1. Register for cab\n2. Delete Registered details of cab share"
					+ "\n3. Searching Cab..\n4. EXIT");
			option_cab_share=input.nextInt();
			System.out.println("\n!!!Please Enter all inputs with underscore in place of space!!!");
		}
	}

}
