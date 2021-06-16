import java.util.ArrayList;
import java.util.List;

public class Service implements IService {

    // Attributs
    public static ArrayList<Local> listeLocal = new ArrayList<Local>();
    private static List<Reservation> listeReservation = new ArrayList<>();
    public static ArrayList<Client> listeClient = new ArrayList<Client>();

    // getters et setters
    public List<Local> getListeLocal() {
		return listeLocal;
	}

	public void setListeLocal(List<Local> listeLocal) {
		Service.listeLocal = (ArrayList<Local>) listeLocal;
	}

	public List<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		Service.listeReservation = listeReservation;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		Service.listeClient = (ArrayList<Client>) listeClient;
	}

//Methodes métiers

    // Créer => ajouter dans la liste

    public void createLocal(Local local) {  	
        listeLocal.add(local);
    }

    public void createClient(Client client) {
        listeClient.add(client);
    }

    public void createReservation(Reservation reservation) {
        listeReservation.add(reservation);
    }



    // afficher ou lister

    public  static void selectLocal(List<Local> mylist) {
        for (Local local : mylist) {
            System.out.println("ref : "+local.getRef()+"\t localisation : "+local.getLocalisation()+"\t type : "+local.getType());
        }
        
    }

    public  static void selectChambre(List<Local> mylist) {
        for (Local local : mylist) {
        	if (local.type=="chambre") {
        		System.out.println("ref : "+local.getRef()+"\t localisation : "+local.getLocalisation()+"\t type : "+local.getType());
        	}
        }
    } 

    public  static void selectAppartement(List<Local> mylist) {
        for (Local local : mylist) {
        	if (local.type=="appartement") {
        		System.out.println("ref : "+local.getRef()+"\t localisation : "+local.getLocalisation()+"\t type : "+local.getType());
        	}
        }
        
    }

    public  static void selectClient(List<Client> mylist) {
        for (Client client : mylist) {
        		System.out.println("nom : "+client.getNomComplet()+" \t NCI : "+client.getNci());
        }
        
    }

    // chercher ou récuperer

    public static Local searchLocal(String refSearch) {
        for (Local local : listeLocal) {
            if (local.getRef().compareTo(refSearch) == 0) {
                return local;
            }
        }
        return null;
    }

    public static Client searchClient(String nci) {
        for (Client client : listeClient) {
            if (client.getNci().compareTo(nci) == 0) {
                return client;
            }
        }
        return null;
    }

    public static Reservation searchReservation(int id){
        for(Reservation reservation : listeReservation){
            if(reservation.getId()==id){
                return reservation;
            }
        }
        return null;
    }

    public static void deleteReservation(Reservation reservation){
        listeReservation.remove(reservation);
    }

    public static void showLocalResByClient(String nci){
        int cpt =0;
        for(Reservation reservation : listeReservation){
            if (reservation.getClient().getNci().compareTo(nci)==0 ){
                cpt+=1;
                System.out.println("id reservation : " +reservation.getId()
                +"  referance local reserve :"+" - "+reservation.getLocal().ref+" - "
                +"localisation : "+reservation.getLocal().localisation+" - "+"prix : "+reservation.getLocal().prix);
            }if(cpt==0){
                System.out.println("Aucune reservation pour ce client ");
            }
        }
        if(cpt !=0){
            System.out.println("Le nombre de locaux que vous avez reservé est : "+cpt);
        }

    }


}
