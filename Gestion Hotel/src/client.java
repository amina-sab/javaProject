import java.time.LocalDate;
import java.time.Period;

public class client {
	int id_client;// the index in the clients table
	String nom;
	String prenom;
	LocalDate naissance;
	int ptCumul; // pour le programme fid�lit� on peut mettre une classe avec les m�thode de
					// rajouter les points et appliquer les promotion a la facture

	public client(String n, String p, String dn) {// "AAAA-MM-JJ"
		nom = n;
		prenom = p;
		naissance = LocalDate.parse(dn);
	}

	public int getId() {
		return id_client;
	}

	// afficher un client
	public void showClient() {
		System.out.println("ID: " + id_client);
		System.out.println("Nom: " + nom);
		System.out.println("Prenom: " + prenom);
		System.out.println("age: " + Period.between(naissance, LocalDate.now()).getYears());// ce truc calcule l'age
																							// avec les jours je sais
																							// pas comment �a marche
																							// vraiment trouv� sur
																							// internet
		// affiche points cumul�s plus la promotion actuel � rajouter
		// affiche reservation (methode � rajouter)
		System.out.println("--------------------------");// pour indiqu� la fin et s�parer des autres r�sultats
	}

}