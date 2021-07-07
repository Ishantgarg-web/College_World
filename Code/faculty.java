package vitcollegeworld;


import java.sql.*;
import java.util.*;
class faculty {

	public static void faculty_registration() {
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
			System.out.println("Choose Option!! What do you want");
			System.out.println("#### WELCOME TO FACULTY PORTAL ####\n\n\n\n1. Register Faculty\n2. Search Faculty By Department\n3. Search Faculty By School Name\n4. Exit");
			int option_faculty_menu = input.nextInt();
			while(option_faculty_menu>=1 && option_faculty_menu<4)
			{
				if(option_faculty_menu == 1)
				{
					System.out.println("Please Input details with underscore in-place of space");
					System.out.println("Enter Faculty Name: ");
					String faculty_name_menu = input.next();
					System.out.println("Enter Faculty Designation: ");
					String faculty_desig_menu = input.next();
					System.out.println("Enter Department of Faculty: ");
					String faculty_depart_menu = input.next();
					System.out.println("Enter School Name: ");
					String faculty_school_name_menu = input.next();
					System.out.println("Enter E-mail id: ");
					String faculty_email_menu = input.next();
					System.out.println("Enter Cabin No: ");
					String faculty_cabin_no = input.next();
					
					if(faculty_name_menu.length()>0 && faculty_desig_menu.length()>0 && faculty_school_name_menu.length()>0)
					{
						String query="insert into faculty values(?,?,?,?,?,?)";
						
						PreparedStatement st=conn.prepareStatement(query);
						st.setString(1, faculty_name_menu);
						st.setString(2, faculty_desig_menu);
						st.setString(3, faculty_depart_menu);
						st.setString(4, faculty_school_name_menu);
						st.setString(5, faculty_email_menu);
						st.setString(6, faculty_cabin_no);
						
						st.executeUpdate();
						System.out.println("Registration is successfully complete with Faculty Name: "+faculty_name_menu);
					}
				}
				else if(option_faculty_menu == 2)
				{
					System.out.println("Please Enter Department Name: ");
					String department_faculty_search = input.next();
					String query="select Faculty_name, Designation, Department, School_name, email_id, cabin_no from faculty where Department=?";
					PreparedStatement st=conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					st.setString(1, department_faculty_search);
					
					ResultSet rs=st.executeQuery();
					if(rs.next()==false)
					{
						System.out.println("Sorry!! No records Found");
					}
					else
					{
						rs.previous();
						while(rs.next())
						{
							if(rs.getString(3).equals(department_faculty_search))
							{
								System.out.println("Faculty Found!!");
								System.out.println("1. Faculty Name: "+rs.getString(1));
								System.out.println("2. Faculty Designation: "+rs.getString(2));
								System.out.println("3. Faculty Department: "+rs.getString(3));
								System.out.println("4. Faculty School Name: "+rs.getString(4));
								System.out.println("5. Faculty Email-Id: "+rs.getString(5));
								System.out.println("6. Faculty Cabin No: "+rs.getString(6));
								return;
							}
						}
						System.out.println("Sorry!! No Records Found");
					}
				}
				else if(option_faculty_menu == 3)
				{
					System.out.println("Please Enter School Name: ");
					String school_name_faculty_search = input.next();
					String query="select Faculty_name, Designation, Department, School_name, email_id, cabin_no from faculty where School_name=?";
					PreparedStatement st=conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					st.setString(1, school_name_faculty_search);
					
					ResultSet rs=st.executeQuery();
					if(rs.next()==false)
					{
						System.out.println("Sorry!! No records Found");
					}
					else
					{
						rs.previous();
						while(rs.next())
						{
							if(rs.getString(3).equals(school_name_faculty_search))
							{
								System.out.println("Faculty Details Found!!");
								System.out.println("1. Faculty Name: "+rs.getString(1));
								System.out.println("2. Faculty Designation: "+rs.getString(2));
								System.out.println("3. Faculty Department: "+rs.getString(3));
								System.out.println("4. Faculty School Name: "+rs.getString(4));
								System.out.println("5. Faculty Email-Id: "+rs.getString(5));
								System.out.println("6. Faculty Cabin No: "+rs.getString(6));
								return;
							}
						}
						System.out.println("Sorry!! No Records Found");
					}
				}
				System.out.println("\n1. Register Faculty\n2. Search Faculty By Department\n3. Search Faculty By School Name\n4. Exit");
				option_faculty_menu = input.nextInt();
			}
			Statement st=conn.createStatement();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

