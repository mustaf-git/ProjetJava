package gestion.reservation;

import java.util.ArrayList;
import java.util.List;

// **** =========== LES FONCTIONNALITES =========== ****
// 1 - Ajouter un local
// 2 - Lister les locaux par type
// 3 - Lister les locaux r�serv� par un client
// 4 - Voir les d�tails d' un local
// 5 - Faire une reservation
// 6 - Annuler une reservation
// 7 - Lister les locaux disponibles
// 8 - Quitter

// Les services � r�aliser : 

public class Service  {

    
   
    // Attributs
    public static ArrayList<Local> listeLocal = new ArrayList<Local>();
   // private List<Local> listeLocal;
    private static List<Reservation> listeReservation = new ArrayList<>();
    //private List<Reservation> listeReservation;
    public static ArrayList<Client> listeClient = new ArrayList<Client>();
    //private List<Client> listeClient;



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


    
    
    //Methodes
    public void createLocal(Local local) {  	
        listeLocal.add(local);
    }


    public void createClient(Client client) {
        listeClient.add(client);
    }


    public void createReservation(Reservation reservation) {
        listeReservation.add(reservation);
    }





    public  static void listerChambre(List<Local> mylist) {
        for (Local local : mylist) {
        	if (local.type=="chambre") {
        		System.out.println(local.getRef());
        	}
        }
    } 

   
    public  static void listerAppartement(List<Local> mylist) {
        for (Local local : mylist) {
        	if (local.type=="appartement") {
        		System.out.println(local.getRef());
        	}
        }
        
    }


    public  static void listerLocal(List<Local> mylist) {
        for (Local local : mylist) {
        	
        		System.out.println(local.getRef());
        	
        }
        
    }





    public static Local searchLocal(String refSearch) {
        for (Local local : listeLocal) {
            if (local.getRef().compareTo(refSearch) == 0) {
                return local;
            }
    
        }
        return null;
    }


    // public Client searchClient(String nci) {

    //     Client client = new Client();
    //     client.setNci(nci);
    //     int pos = listeClient.indexOf(client);
    //     if (pos != -1)
    //     {
    //         return listeClient.get(pos);
    //     }
    //     return null;
    // }
    

    public static Client searchClient(String nci) {
        for (Client client : listeClient) {
            if (client.getNci().compareTo(nci) == 0) {
                return client;
            }
    
        }
        return null;
    }


    public  static void listerClient(List<Client> mylist) {
        for (Client client : mylist) {
        	
        		System.out.println("nom : "+client.getNomComplet()+" \t NCI : "+client.getNci());
        	
        }
        
    }


    public static void showLocalResByClient(String nci){
        int cpt =0;
        for(Reservation reservation : listeReservation){
            if (reservation.getClient().getNci().compareTo(nci)==0 ){
                cpt+=1;
                System.out.println("id reservation : "+reservation.getId()
                +"referance local reserve :"+" - "+reservation.getLocal().ref+" - "
                +"localisation : "+reservation.getLocal().localisation+" - "+"prix : "+reservation.getLocal().prix);
            }if(cpt==0){
                System.out.println("Aucune reservation pour ce client ");
            }
        }
        if(cpt !=0){
            System.out.println("Le nombre de locaux reservé par ce client est : "+cpt);
        }

    }
   

    public static void deleteReservation(int id){
        for (Reservation reservation : listeReservation){
            if(reservation.getId()==id){
            // ******
            // on remet ce local dans la liste des locaux : sera dispo maintenant 
            listeLocal.add(reservation.getLocal());
            // on supprime cette reservation dans la liste des reseravtions 
            listeReservation.remove(reservation);
            }
        }
    }


    public  static void listerLocalDispo(List<Local> mylist) {
        for (Local local : mylist) {
        	
        		System.out.println(local.getRef());
        	
        }
        
    }




    public void listerLocalForOneClient(String nci) {
        // TODO Auto-generated method stub
        
    }

    
  
    public void showDetailsChambre(Local chambre) {
        // TODO Auto-generated method stub
        
    }


 
    public void showDetailsAppartement(Local appartement) {
        // TODO Auto-generated method stub
        
    }


   
    public void showDetailsLocal(String ref) {
        // TODO Auto-generated method stub
        
    }




    


  
    

 
    public void showLocalDisponible() {
        // TODO Auto-generated method stub
        
    }


  
    public void selectionneLocal(String ref) {
        // TODO Auto-generated method stub
        
    }


   
    


 
    public String getNci(Client client) {
        // TODO Auto-generated method stub
        return null;
    }


    
    public void showReservationForClient(String nci) {
        // TODO Auto-generated method stub
        
    }


   
    public void selectionneReservation(int id) {
        // TODO Auto-generated method stub
        
    }


  
    public void annulerReservation(int id) {
        // TODO Auto-generated method stub
        
    }

}
