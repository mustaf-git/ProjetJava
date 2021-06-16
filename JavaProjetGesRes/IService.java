import java.util.List;

public interface IService {




								//  =========== LES FONCTIONNALITES =========== 



		// 1 - Ajouter un local : 
				
				//public void createLocal(Local local); // creer le local : ajouter le local dans la liste des locaux
		
		
		
		// 2 - Lister les locaux par type : 

				// public  void listerChambre(); // si type = chambre ==> on affiche tout d'une part 
				// public void listerAppartement(); // si type = appartement ==> on affiche tout d'autre part 



		// 3 - Lister les locaux reserves par un client : 

				//public void searchClient(String nci) ==> nous renvoit le client dans la liste des reservation
				//public void listerLocalForOneClient(String nci); // == > lister les locaux reserves par un client



		// 4 - Voir les details d' un local

				//public void searchLocal(String ref) ==> le local
				//public void showDetailsLocal(String ref); // les details d'un local == > type


		// 5 - Faire une reservation : 

				// public void shearchClient(String nci); // true or false
				// si false : public void createClient(Client client); 
				// si true : client existe on le cree pas 
				// public void showLocalDisponible(); // on affiche la liste des locaux disponibles 
				// public void selectionneLocal(String ref); // selectionne un local a reserver en tapant sa reference
				// public void reserverLocal(Local local); // on lui reserve ce local : en ajoutant ce local dans la liste des locaux

				
		// 6 - Annuler une reservation

				// public String getNci(Client client); // obtenir le nci du client qui annule une reservation
				// public void showReservationForClient(String nci); // == > lister les reservations de ce client
				// public void selectionneReservation(int id); // selectionne une reservation a annuler en tapant l'id de la reservation
				// public void annulerReservation(int id); // on anuule la reservation qui a pour id l'id choisi en le suuprimant du tableau de reservation du client



		// 7 - Lister les locaux disponibles


				//public void showLocalDisponible(); // on affiche la liste des locaux disponibles et les references :liste local - liste local reserve   
				//public void listerLocals(); // == > 



		// 8 - Quitter

				//afficher bye bye


	public void createLocal(Local local); // 							creer une liste de locaux
    public void createClient(Client client); // 						creer une liste de clients
    public void createReservation(Reservation reservation); // 			creer une liste de reservation




    public  static void selectLocal(List<Local> mylist){ // 			afficher local
	}
    public  static void selectChambre(List<Local> mylist){ //			afficher chambre
	}
    public  static void selectAppartement(List<Local> mylist){ //		afficher appartement
	}
    public  static void selectClient(List<Client> mylist){ //			afficher client
	}



    public static Local searchLocal(String refSearch){// 				trouver local
		return null;	
	}
    public static Client searchClient(String nci){// 					trouver client
		return null;	
	}
    public static Reservation searchReservation(int id){// 				trouver reservation
		return null;	
	}


	public static void showLocalResByClient(String nci){//				trouver local pour client
	}
    public static void deleteReservation(Reservation reservation){// 	supprimer reservation
	}
    public  static void selectLocalDispo(List<Local> mylist){//			afficher locaux disponibles
	}   

}