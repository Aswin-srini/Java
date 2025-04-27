import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner in=new Scanner(System.in);
		SelectModul n = new SelectModul();
		
		while(true) {
			System.out.println("\n\tWelccome to AB Cinemas");
			System.out.println("\n1) New Registration");
			System.out.println("2) Log-In with ID");
			
			
			
			System.out.println("\nEnter the Number (1or2):");
			int op = in.nextInt();
			
				
			switch(op) {
			case 1:
				System.out.println("Enter the Name:");
				String Name = in.next();
				in.nextLine();
				System.out.println("Enter the Phon no:");
				double Phno = in.nextDouble();
				System.out.println("create the ID:");
				int ID = in.nextInt();
				int ID_len = (int) Math.floor(Math.log10(ID)) + 1;
					if(ID_len <= 3) {
						new DataBase(Name,Phno,ID);
						if(DataBase.Insert_user()) {
							System.out.println("Wanna book Ticket");
							System.out.println("Enter"+" Y "+" to book or click Any button to exit");
							char o=in.next().charAt(0);
							if(o =='y'){
								n.Movie(ID);
							}
							else {
								System.out.println("Successfully reg!!!");
								System.out.println("\tThank you for visite AB cinemas");
							}
						}
					}
					else {
						System.out.println("****ID within 3****");
					}
					break;
			case 2:
				System.out.println("Enter the ID:");
				int id = in.nextInt();
				
				
				System.out.println("1)Book Ticket");
				System.out.println("2)view My Bookings");
				System.out.println("Enter 1 or 2");
				int op1=in.nextInt();
				switch(op1) {
				case 1:
					if(DataBase.ID_Check(id)) {
						n.Movie(id);
					}
					else {
						System.out.println("****************");
						System.out.println("U Don't Have ID");
						System.out.println("Create New");
					}
				break;
				case 2:
					DataBase.get_Ticket(id);
					break;
				}
				break;
			default:
				System.out.println("Click 1 or 2 ");
			}
		}
	}
}
