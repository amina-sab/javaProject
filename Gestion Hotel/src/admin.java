import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class admin {
	ArrayList<chambre> rooms = new ArrayList<chambre>();
	ArrayList<client> clients = new ArrayList<client>();
	ArrayList<reservation> reservations = new ArrayList<reservation>();
	ArrayList<sejour> sejours = new ArrayList<sejour>();

	//////////////////////////////////////////////////////////////
	///////////////// GESTION DES CHAMBRES /////////////////////
	////////////////////////////////////////////////////////////

	// saisir une chambre

	public void addRoom(chambre c) {// plus the id
		rooms.add(c);
		c.num_ch = rooms.indexOf(c) + 1;// pour qu'on aura pas un id 0
	}

	// afficher toutes les chambres dispo et non dispop

	public void showRooms() {
		for (chambre c : rooms) {
			System.out.println(c.showRoom());
		}

	}

	// modifier une chambre
	// -----> le cout //-----> la disponibilite //-----> l'etat /----->

	// getPrice of room with num room

	public int getPrice(int id_ch) {
		int price = 0;
		for (chambre ch : rooms) {
			if (ch.num_ch == id_ch) {
				price = ch.getPrice();
			}
		}
		return price;
	}

	////////////////////////////////////////////////////////////////
	///////////////// GESTION DES CLIENTS /////////////////////
	////////////////////////////////////////////////////////////////

	// ajouter un client
	public void addClient(client cl) {// plus setting the client id
		clients.add(cl);
		cl.id_client = clients.indexOf(cl) + 1;
	}

	// afficher les clients � partir d'un nom et un pr�nom (on peut rajouter avec le
	// nom ou pr�nom seulement)

	public void showClient(String clientName, String clientPre) {
		for (client c : clients) {
			if (c.nom.equals(clientName) && c.prenom.equals(clientPre)) {
				c.showClient();
			}
		}
	}

	// show all clients
	public void showClient() {
		for (client c : clients)
			c.showClient();

	}

	// recup�rer l'id d'un client � partir d'un nom et prenom
	public ArrayList<Integer> getClientId(String clientName, String clientPre) {
		ArrayList<Integer> cls = new ArrayList<Integer>();
		for (client c : clients) {
			if (c.nom.equals(clientName) && c.prenom.equals(clientPre)) {
				cls.add(c.id_client);
			}
		}

		if (cls.size() == 0) { // le cas ou on ne trouve pas le client
			System.out.println("client is not registered");
		}

		return cls;
	}

	// supprimer un client
	public String getClientName(int id) {
		String n = "not found";
		for (client c : clients) {
			if (c.id_client == id) {
				n = c.nom + " " + c.prenom;
			}
		}

		return n;
	}

	// on affiche des messages pour eviter les erreurs et aussi quand on a plusieurs
	// clients au meme nom �a nous permet de supprimer celui qu'on veut
	public void deleteClient(int cl_id) {
		String answr = JOptionPane.showInputDialog(
				"do you really want to remove client " + getClientName(cl_id) + " ? (Y to confirm N to cancel)");
		if (answr.equalsIgnoreCase("Y")) {
			JOptionPane.showMessageDialog(null, getClientName(cl_id) + " is removed.");
			clients.remove(cl_id);
		} else if (answr.equalsIgnoreCase("N")) {
			JOptionPane.showMessageDialog(null, getClientName(cl_id) + " is not removed.");
		} else {
			deleteClient(cl_id);
		}

	}

	public void deleteClient(String nom, String prenom) {
		ArrayList<Integer> cls = new ArrayList<Integer>();
		cls = getClientId(nom, prenom);
		if (cls.size() != 0) {
			for (int i : cls) {
				deleteClient(i);
			}
		}
	}

	////////////////////////////////////////////////////////////////
	///////////////// GESTION DES RESERVATIONS /////////////////////
	////////////////////////////////////////////////////////////////

	// chercher les chambres disponibles
	public ArrayList<chambre> getRooms(LocalDate deb, LocalDate fin) {
		ArrayList<chambre> roomsDispo = new <chambre>ArrayList();
       
		for (reservation r : reservations) {

			if (fin.isBefore(r.reserv_debut))  {
			 roomsDispo.add(r.ch);
			} else if (deb.isAfter(r.reserv_fin)) {
				roomsDispo.add(r.ch);
			}
		}
		for(chambre c:rooms){

		}

		return roomsDispo;
	}

	// public String chambre_dispo() fautg�rer les intervalle de temps read
	// LocalDate and Period methods
	// �crire plusieurs version concernant le type ou le nombre de personne

	public void ajout_reserv() {

	}

	public void annul_reserv() {

	}

	//////////////////////////////////////////////////////////////
	///////////////// GESTION DES SEJOURS ///////////////////////
	/////////////////////////////////////////////////////////////
	public void addSejour(sejour s) {// plus the id
		sejours.add(s);
		s.id_sejour = sejours.indexOf(s) + 1;// pour qu'on aura pas un id 0
	}

	public void addBill() {

		for (sejour s : sejours) {
			for (reservation r : reservations)
				if (r.id_client == s.id_client) {
					s.bill = r.getCout() + s.sumConso();
				}

		}
	}

	public int getBill(client cl) {

		int b = 0;
		for (sejour s : sejours) {
			if (cl.id_client == s.id_client)
				b = s.getBill();
		}
		return b;
	}

}
