
package vitcollegeworld;

import vitcollegeworld.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
class Resources {

	public static void resources() throws Exception {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/vit_college";
		String uname="root";
		String pass="root";
		Connection conn=null;
		
		Scanner input=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, uname, pass);
		}
		catch(Exception e)
		{
			System.out.println("There is Connection Problem");
		}
		try {
			boolean check_again=true;
			while(check_again) {
			System.out.println("**Please Enter all inputs with underscore in-place of space**\nPlease select Subject Name, if you want to got back then enter -1");
			String subject_name_resources = input.next();
			System.out.println("Please Enter Subject code: ");
			String subject_code_resources = input.next();
			if(subject_name_resources.length()>0 && subject_name_resources.equals("-1")==false)
			{
				System.out.println("Please Select Appropriate options");
				System.out.println("\n1. Cat1\n2. Cat2\n3. Fat\n4. Quiz\n5. EXIT");
				int option_resources_material = input.nextInt();
				while(option_resources_material>=1 && option_resources_material<=4)
				{
					String query="",temp="";
					if(option_resources_material == 1)
					{
						temp="cat1";
					}
					else if(option_resources_material == 2)
					{
						temp="cat2";
					}
					else if(option_resources_material == 3)
					{
						temp="fat";
					}
					else if(option_resources_material == 4)
					{
						temp="quiz";
					}
					query="select subject_name,"+temp+" from resources2 where subject_name=?";
					PreparedStatement st=conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					st.setString(1, subject_name_resources);
						
					ResultSet rs=st.executeQuery();
						
					if(rs.next()==false)
					{
						System.out.println("There is no such record in database");
					}
					else
					{
						rs.previous();
						while(rs.next())
						{
							System.out.println("Subject Name is: "+rs.getString(1));
							System.out.println("url is: "+rs.getString(2));
							//rs.next();
						}
					}
					System.out.println("** You can also upload Material, if you don't want to add enter -1**");
					String upload_material_resources = input.next();
					if(upload_material_resources.equals("-1")==false)
					{
						String query1="insert into resources2 values(?,?,?,?,?)";
						String query2="insert into resources1 values(?,?)";
						PreparedStatement st2=conn.prepareStatement(query2);
						PreparedStatement st1=conn.prepareStatement(query1);
						st2.setString(1, subject_code_resources);
						st2.setString(2, subject_name_resources);
						st2.executeUpdate();
						st1.setString(1, subject_name_resources);
						if(temp.equals("cat1"))
						{
							st1.setString(2, upload_material_resources);
							st1.setString(3, null);
							st1.setString(4, null);
							st1.setString(5, null);
						}
						else if(temp.equals("cat2"))
						{
							st1.setString(2, null);
							st1.setString(3, upload_material_resources);
							st1.setString(4, null);
							st1.setString(5, null);
						}
						else if(temp.equals("fat"))
						{
							st1.setString(2, null);
							st1.setString(3, null);
							st1.setString(4, upload_material_resources);
							st1.setString(5, null);
						}
						else if(temp.equals("quiz"))
						{
							st1.setString(2, null);
							st1.setString(3, null);
							st1.setString(4, null);
							st1.setString(5, upload_material_resources);
						}
						st1.executeUpdate();
						System.out.println("You uploaded data SUCCESSFULLY!!");
					}
					System.out.println("Please Select Appropriate options");
					System.out.println("\n1. Cat1\n2. Cat2\n3. Fat\n4. Quiz\n5. EXIT");
					option_resources_material = input.nextInt();
				}
					
			}
			else
			{
				System.out.println("You have successfully exit!!");
				return;
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
