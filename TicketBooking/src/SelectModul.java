
import java.sql.SQLException;
import java.util.Scanner;

public class SelectModul {
	String movie="Interstellar";
	String Row[][]= {
			{"A:","1","2","3","4","5"},
			{"B:","1","2","3","4","5"},
			{"C:","1","2","3","4","5"},
			{"D:","1","2","3","4","5"},
	};
	
	Scanner in=new Scanner(System.in);
	
	public String[][] Seat() {
		System.out.println("**********************");
		for (int i = 0; i < Row.length; i++) {
            for (int j = 0; j < Row[i].length; j++) {
                System.out.print(Row[i][j] + " ");
            }
            System.out.println();
        }
		System.out.println("**********************");
		return Row;
	}
	
	public String[][] sel(int id) throws SQLException{
		
		char Ch_int;
		
		System.out.println("No.of Tickets;");
		int ct = in.nextInt();
		
		String s[]=new String[ct];
		String sel_seat = null;
		
		Seat();
		System.out.println("Enter the ROW:");
		String r = in.next().toLowerCase();
		Ch_int= (char) (r.charAt(0)) ;
		int row=Ch_int - 97;
		
		System.out.println("Enter the Seat no:");
		for(int i=0;i<ct;i++) {
			String Seatno = in.next();
			s[i]=(String) Seatno;
			int Col = Integer.valueOf(s[i]);
			Row[row][Col] = "*";
		}
		
		String Sel_row=r.toUpperCase();
		
		for (int i=0;i<s.length;i++) {
			sel_seat = String.join(",", s);
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Your Booked "+movie+" movie From AB Cinema ");
		System.out.println( "Your Seat Are:" +" "+ Sel_row + " " +sel_seat);
		
		DataBase.Insert_Ticket(id,Sel_row,sel_seat);
		
		return Row;
	}

	public void Movie(int id) throws SQLException {
		
			System.out.println(movie);
			System.out.println("Set in a dystopian future where Earth is \nsuffering from catastrophic blight and famine,the film follows a group of astronauts who travel through a wormhole near Saturn \nin search of a new home for mankind.");
			System.out.println("****************************************************");
		sel(id);
	}
	
}

