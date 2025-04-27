
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class  DataBase {
	
		static String Name;
		static double Phno;
		static int ID;
	
		DataBase(String Name,double Phno,int ID){
			
			DataBase.Name=Name;
			DataBase.Phno=Phno;
			DataBase.ID=ID;
		}
		
		public static boolean Insert_user() throws SQLException {
			String url="jdbc:mysql://localhost:3306/Ticketbooking";
			String Username="root";
			String Password="root";
			
			boolean chk = true;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection Connection = DriverManager.getConnection(url,Username,Password);
				
				Statement in=Connection.createStatement();
					try {
						int add = in.executeUpdate("INSERT INTO users VALUES("+ID+",'"+ Name +"'," + Phno + ")");
							if(add>0) {
								System.out.println("Successfully reg!!!");
							}
						}
					catch(SQLIntegrityConstraintViolationException e) {
						System.out.println("***ID  will Already Exists***");
						chk=false;
					}
			}
			catch (ClassNotFoundException e) {
				
				System.out.println("***DataBase Connection Error***");
			}
			return chk;
			
		}

		public static void Insert_Ticket(int ID,String row,String Seat) throws SQLException{
			String url="jdbc:mysql://localhost:3306/Ticketbooking";
			String Username="root";
			String Password="root";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,Username,Password);
				Statement in = con.createStatement();
				
				int add = in.executeUpdate("INSERT INTO Ticket_det VALUES("+ID+",'"+row+"','"+Seat+"')");
				if(add>0) {
					System.out.println("Ticket Book SuccessFully!!!");
				}
			}catch(ClassNotFoundException e){
				System.out.println("***DataBase Connection Error***");
			}
		}
		
		public static boolean ID_Check(int ID) throws SQLException{
			String url="jdbc:mysql://localhost:3306/Ticketbooking";
			String Username="root";
			String Password="root";
			
			boolean check = false;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,Username,Password);
				Statement in = con.createStatement();
				
				ResultSet rs=in.executeQuery("SELECT ID FROM USERS ");
				
				while(rs.next()) {
					int id=rs.getInt("ID");
					if(id==ID) {
						check= true;
					}
				}	
			}catch(ClassNotFoundException e){
				System.out.println("***DataBase Connection Error***");
			}
			return check;
		}
		
		public static void get_Ticket(int ID) throws SQLException{
			String url="jdbc:mysql://localhost:3306/Ticketbooking";
			String Username="root";
			String Password="root";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection Con = DriverManager.getConnection(url,Username,Password);
				
				Statement st=Con.createStatement();
				
				String get_Query="select users.name,Ticket_Det.ID,Ticket_Det.ROW,Ticket_Det.SEATS FROM users inner join Ticket_Det ON users.ID = Ticket_Det.ID WHERE users.ID =";
				ResultSet rs= st.executeQuery(get_Query + ID);
				
				while(rs.next()) {
					int id=rs.getInt("ID");
					String name =rs.getNString("name");
					String row =rs.getNString("ROW");					
					String seat =rs.getNString("SEATS");
					
					System.out.println(id +"|    " + name + "   |   " + row +"-"+seat);
				}
				
			}catch(ClassNotFoundException e) {
				System.out.println("***DataBase Connection Error***");
			}
			
		}
			
}