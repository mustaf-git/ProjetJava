package gestion.reservation;

public interface IService {


								// **** =========== LES FONCTIONNALITES =========== ****
								// 1 - Ajouter un local
								// 2 - Lister les locaux par type
								// 3 - Lister les locaux r�serv� par un client
								// 4 - Voir les d�tails d' un local
								// 5 - Faire une reservation
								// 6 - Annuler une reservation
								// 7 - Lister les locaux disponibles
								// 8 - Quitter

	
	    public void createLocal(Local local); // creer le local


	public  void listerChambre(); // si type = chambre ==> on affiche tout d'une part 
	public void listerAppartement(); // si type = appartement ==> on affiche tout d'autre part 
	    public void listerLocals(); // == > d�clanche la proc�dure d'affichage

	public void listerLocalForOneClient(String nci); // == > lister les locaux r�serv�s par un client


	public void showDetailsChambre(Local chambre); // les d�tails d'une chambre si type = chambre
	public void showDetailsAppartement(Local appartement); // les d�tails d'un appartement si type = appartement
	    public void showDetailsLocal(String ref); // les d�tails d'un local == > type



	public void shearchClient(String nci); // true or false
	public void createClient(Client client); // false
	// si true : client existe on le cr�e pas 
	public void showLocalDisponible(); // on affiche la liste des locaux disponibles et les references :liste local - liste local reserve
	public void selectionneLocal(String ref); // selectionne un local � reserver en tapant sa reference
	    public void reserverLocal(Local local); // on lui reserve ce local 



	public String getNci(Client client); // obtenir le nci du client qui annule une reservation
	public void showReservationForClient(String nci); // == > lister les reservations de ce client
	public void selectionneReservation(int id); // selectionne une reservation � annuler en tapant l'id de la reservation
	    public void annulerReservation(int id); // on anuule la reservation qui a pour id l'id choisi en le suuprimant du tableau de reservation du client


	    //public void showLocalDisponible(); // on affiche la liste des locaux disponibles et les references :liste local - liste local reserve   
	}