import java.time.LocalDate;
import java.time.Period;


public class main {

	public static void main(String[] args) {
		//rooms test
		 admin room = new admin();
		 LocalDate d =  LocalDate.now();
	        chambre c1 = new chambre(01, 01, 'S');
	        chambre c2 = new chambre(02, 01, 'D');
	        chambre c3 = new chambre(03, 03, 'E');
	        room.addRoom(c1);
	        room.addRoom(c2);
	        room.addRoom(c3);
	     room.affiche_rooms();
	     
	     //client age test
	        System.out.println(Period.between(d, LocalDate.parse("2000-05-01")).getYears());
	        
	    //clients test
	        admin clients = new admin();
	        client cl1 = new client("A", "a", "2020-06-12");
	        client cl2 = new client("B", "b", "2020-06-12");
	        client cl3 = new client("C", "c", "2020-06-12");
	        // clients.addClient(cl1);
	        // clients.addClient(cl2);
	        // clients.addClient(cl3);
	        
	        // clients.showClient();
	        // clients.suppClient(3);
	        // clients.showClient();



			System.out.println("--------------------------------------------------------------------");

			LocalDate d1 =  LocalDate.now();
			LocalDate d2 =  LocalDate.parse("2022-05-06");

			
				System.out.println(d1.isBefore(d2));

			

	}

}
