import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class admin {
	ArrayList<chambre> rooms = new ArrayList<chambre>();
	ArrayList<client> clients = new ArrayList<client>();
	ArrayList<reservation> reservations = new ArrayList<reservation>();

	//////////////////////////////////////////////////////////////
	///////////////// GESTION DES CHAMBRES /////////////////////
	////////////////////////////////////////////////////////////

	// saisir une chambre

	public void addRoom(chambre c) {// plus the id
		rooms.add(c);
		c.num_ch = rooms.indexOf(c) + 1;// pour qu'on aura pas un id 0
	}

	// afficher toutes les chambres dispo et non dispop

	public void affiche_rooms() {
		for (chambre c : rooms) {
			System.out.println(c.affiche_ch());
		}

	}

	// modifier une chambre
	// -----> le cout //-----> la disponibilite //-----> l'etat /----->

	public void modifRoom() {

		// modifier le prix ou le type de chambre
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
	public void suppClient(int cl_id) {
		String answr = JOptionPane.showInputDialog(
				"do you really want to remove client " + getClientName(cl_id) + " ? (Y to confirm N to cancel)");
		if (answr.equalsIgnoreCase("Y")) {
			JOptionPane.showMessageDialog(null, getClientName(cl_id) + " is removed.");
			clients.remove(cl_id);
		} else if (answr.equalsIgnoreCase("N")) {
			JOptionPane.showMessageDialog(null, getClientName(cl_id) + " is not removed.");
		} else {
			suppClient(cl_id);
		}

	}

	public void suppClient(String nom, String prenom) {
		ArrayList<Integer> cls = new ArrayList<Integer>();
		cls = getClientId(nom, prenom);
		if (cls.size() != 0) {
			for (int i : cls) {
				suppClient(i);
			}
		}
	}

	////////////////////////////////////////////////////////////////
	///////////////// GESTION DES RESERVATIONS /////////////////////
	////////////////////////////////////////////////////////////////

	// chercher les chambres disponibles
	public ArrayList <chambre> getRooms(LocalDate deb,LocalDate fin){
		ArrayList  <chambre> ch=new <chambre> ArrayList();
		
		for(reservation r : reservations){
			
		}


		return ch;
	}

	// public String chambre_dispo() fautg�rer les intervalle de temps read
	// LocalDate and Period methods
	// �crire plusieurs version concernant le type ou le nombre de personne

	public void ajout_reserv() {

	}

	public void annul_reserv() {

	}

}
