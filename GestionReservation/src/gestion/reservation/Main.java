package gestion.reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    
    public static Scanner scanner = new Scanner(System.in);
    
    Service service = new Service();
    
	
    
    
    public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	

	public static void main(String[] args) {

        Service service = new Service();
        int choix;
        do
        {
        	
            choix = menu();
            switch(choix){
            case 1:// Ajouter un local
            	
                    System.out.println(" Ajout'un local ");
                    int typeInt;
                    do{ // Choix du type de local : 
                        System.out.print(
                            " 1 - Chambre "
                            +"\n 2 - Appartement "
                    		+"\n" +"Quel type de local veux tu ajouter : "
                        );
                        typeInt = Integer.parseInt(scanner.nextLine());
                    }while(typeInt !=1 && typeInt !=2);
                    
                    // d�clare un local
                    
                    
                    if(typeInt==1) // On cr�e une chambre : 
                    	
                    {
                        Local local = new Chambre();
                    	String ref = local.getRef();
                        System.out.print("Entrer la localisation :");
                        String localisation = scanner.nextLine();
                        System.out.print("Entrer le prix :");
                        int prix = Integer.parseInt(scanner.nextLine());
                        System.out.print("Entrer le taux locatif :");
                        int tauxLoc = Integer.parseInt(scanner.nextLine());
                        String type = "chambre";
                        System.out.print("Entrer les dimensions :");
                        String dimension = scanner.nextLine();                       
                        Local chambre = new Chambre(ref, localisation, prix, tauxLoc, type, dimension);
                        chambre.setLocal(chambre);
                        System.out.println("La chambre est bien ajout�e ! ");
                        System.out.println("Affichage des donn�es de la chambre ajout�e :");
                        System.out.println(chambre.afficher());
                        //cr�ons ce local dans la liste des locals
                        service.createLocal(chambre);                        
                        
                    }else{ // On cr�e un appartememnt
                        Local local = new Appartement();
                    	String ref = local.getRef();
                        System.out.print("Entrer la localisation :");
                        String localisation = scanner.nextLine();
                        System.out.print("Entrer le prix :");
                        int prix = Integer.parseInt(scanner.nextLine());
                        System.out.print("Entrer le taux locatif :");
                        int tauxLoc = Integer.parseInt(scanner.nextLine());
                        String type = "appartement";
                        System.out.print("Entrer le nombre de chambres :");
                        int nombrePieces = Integer.parseInt(scanner.nextLine());                       
                        Local appartement = new Appartement(ref, localisation, prix, tauxLoc, type, nombrePieces);
                        appartement.setLocal(appartement);
                        System.out.println("L'appartement est bien ajout� ! ");
                        System.out.println("Affichage des donn�es de l'appartement ajout� :");
                        System.out.println(appartement.afficher());
                        //cr�ons ce local dans la liste des locals
                        service.createLocal(appartement);
                    }
                break;
            case 2:// lister les locaux par type
              	 int typeLocal;

                System.out.println("Lister les locaux par type" );
               
                
                do{ // Choix du type de local :
                    System.out.print(
                        " 1 - Chambre "
                        +"\n 2 - Appartement "
                		+"\n" +"Quel type de local veux tu ajouter : "
                    );
                    typeLocal = Integer.parseInt(scanner.nextLine());
                }while(typeLocal !=1 && typeLocal !=2);
                
                if(typeLocal==1) {
                	Service.listerChambre(Service.listeLocal);
                }else if(typeLocal==2) {
                	Service.listerAppartement(Service.listeLocal);
                }
                break;
            case 3:
                System.out.print("Lister les locaux reserve par un client ");
                System.out.println("Le nci du client qui veut voir ses reservations : ");
                String nci = scanner.nextLine();
                Client client = Service.searchClient(nci);
                
                if( client != null) {
                	System.out.println("Vous etes un client  ");
                    System.out.println("Voic l'ensemble des locaux que vous avez reserve");      		
                	Service.showLocalResByClient(nci);
                }else{
                    System.out.println("Vous n'etes pas un client");
                }
                break;
            case 4:
                System.out.println("Voir les details d'un local");
                System.out.println("Veuillez mettre la reference du local concerne : ");
                String refSearch = scanner.nextLine();
                Local loc = Service.searchLocal(refSearch);
                
                if( loc != null) {
                	System.out.println("Les details du local sont : ");      		
                	System.out.println(loc.afficher());
                }else {
                	System.out.println("Le local saisi n'existe pas ");
                }
                // Le probl�me c'est le ref 
                // bas dévine quoi c'est résolu
                
                
                
                break;
            case 5:

                System.out.println("Faire une reservation ");
                System.out.println("Veuillez entrer le nci  : ");
                nci = scanner.nextLine();
                client = Service.searchClient(nci);
                
                if( client != null) {
                	System.out.println("Vous etes déja un client  ");      		
                	System.out.println("Votre nom est : "+client.getNomComplet());
                }else {
                    // client n'existe pas => on le crée
                    System.out.println("Vous n'êtes pas dans la liste des client \nInscription : ");
                    System.out.println("Veuillez mettre le nom complet : ");
                    String nomComplet = scanner.nextLine();
                    System.out.println("Veuillez mettre votre telephone : ");
                    String tel = scanner.nextLine();
                    System.out.println("Veuillez mettre votre adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.println("Veuillez mettre votre email : ");
                    String email = scanner.nextLine();
                    // on instancie le client
                    client = new Client(nci, nomComplet, tel, adresse, email);
                    // on ajoute le client dans la liste des clients
                    service.createClient(client);
                    System.out.println("Client crée avec sucées");
                }

                // On affiches les locaux
                System.out.println("Voici la liste des locaux disponibles ");
                // ici j'ai pris tous les locaux : c'est pas bon je dois prendre la liste des locales dispo
                Service.listerLocal(Service.listeLocal);

                // on prend la reference du local à reserver
                System.out.println("Veuillez mettre la reference du local concerne : ");
                refSearch = scanner.nextLine();
                loc = Service.searchLocal(refSearch);//local
                
                if( loc != null) {
                	System.out.println("Les details du local que vous souhaitez reservez : ");      		
                	System.out.println(loc.afficher());

                    // Infos de la reservation
                    System.out.println("Faisons la reservations maintenant ");
                    
                    System.out.println("Veuillez mettre la duré de la reservation : ");
                    String dure = scanner.nextLine();
                    System.out.println("Veuillez mettre l'état de la reservation : ");
                    String etat = scanner.nextLine();
                    Reservation reservation = new Reservation();
                    int id = reservation.getId();
                    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    System.out.println("La date de la reservation est \t");
                    System.out.println(s.format(date));

                    // faire reservation :instancie  hydrate reservation
                    reservation = new Reservation(date, dure, etat, id, loc, client);
                    // ajoueter cette reservation dans la liste des reservation
                    service.createReservation(reservation);

                    //*****
                    // on supprime ce local dans la liste des locaux
                    service.getListeLocal().remove(loc);



                    System.out.println("La reservation a été faite avec succés.");
                    System.out.println(reservation.toString(s.format(date),loc,client));
                }else {
                	System.out.println("La reference du local saisi n'existe pas ");
                }

                break;
            case 6:
            System.out.print("Annuler une reservation ");
            System.out.println("Le nci du client qui veut annuler une reservation : ");
            nci = scanner.nextLine();
            client = Service.searchClient(nci);
            
            if( client != null) {
                System.out.println("Vous etes un client  ");
                System.out.println("Voic l'ensemble des locaux que vous avez reserve");      		
                Service.showLocalResByClient(nci);
                System.out.println("Mettre l'id de la reservation à annuler");
                int id = Integer.parseInt(scanner.nextLine());
                Service.deleteReservation(id);
            }else{
                System.out.println("Vous n'etes pas un client");
            }

                

                break;
            case 7:
                System.out.println("Lister les locaux disponibles"); 
                Service.listerLocalDispo(Service.listeLocal);
                break;
            case 8:
                System.out.println(" Bye Bye ( .. ) "); 
                break;
            default:
                System.out.println("Mauvais choix : \nMerci de choisir les options disponibles ");
            }
            
        } while (choix != 8);
       /* for(Local loc: Service.listeLocal) {
        	System.out.println(loc.prix);
        }*/
      
		 

    }

    public static int menu()
    {
        int choix;
        System.out.println
        ("Menu"
        + "\n 1 - Ajouter un local "  
        + "\n 2 - Lister les locaux par type "
        + "\n 3 - Lister les locaux reserve par un client "
        + "\n 4 - Voir les details d'un local "
        + "\n 5 - Faire une reservation "
        + "\n 6 - Annuler une reservation "
        + "\n 7 - Lister les locaux disponibles "
        + "\n 8 - Quitter");
        System.out.print("Faites votre choix : ");
        choix = Integer.parseInt(scanner.nextLine());
        return choix;
}

}

