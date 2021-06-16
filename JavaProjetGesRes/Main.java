import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    Service service = new Service();
	public static void main(String[] args) {
        Service service = new Service();
        int choix;
        do
        {
            choix = menu();
            switch(choix){
            case 1:
            	
                System.out.println("\n ( .. ) Ajouter un local ( .. ) \n");

                    int typeInt;
                    do{
                        System.out.print(

                            "\n Quel type de local veux tu ajouter ? : "
                            +"\n 1 - Chambre "
                            +"\n 2 - Appartement "

                        );
                        typeInt = Integer.parseInt(scanner.nextLine());
                    }while(typeInt !=1 && typeInt !=2);

                    if(typeInt==1) // On cree une chambre
                    {
                        Local local = new Chambre();

                        // On récupere les donnees de la chambre en controlant ce que l'utilisateur a saisi

                    	String ref = local.getRef();

                        String localisation;
                        do{
                            System.out.print("Veuillez entrer la localisation : ");
                            localisation = scanner.nextLine();
                        }while(ClValidator.isNotEmpty(localisation)!=true || ClValidator.isString(localisation)!=true);


                        String StrPrix;
                            do{
                            System.out.print("Merci de saisir le prix : ");
                            StrPrix = scanner.nextLine();
                            }while(ClValidator.isNumeric(StrPrix)!=true);
                        int prix = Integer.parseInt(StrPrix);

                        String StrTaux;
                            do{
                            System.out.print("Merci de saisir le taux locatif : ");
                            StrTaux = scanner.nextLine();
                            }while(ClValidator.isNumeric(StrTaux)!=true);
                        int tauxLoc= Integer.parseInt(StrTaux);
                        String type = "chambre";

                        String dimension;
                        do{
                            System.out.print("Veuillez entrer la dimension : ");
                            dimension = scanner.nextLine();
                        }while(ClValidator.isNotEmpty(dimension)!=true || ClValidator.isString(dimension)!=true);

                        // instanciation et hydratation de la chambre créée
                        Local chambre = new Chambre(ref, localisation, prix, tauxLoc, type, dimension);
                        //on modifie le local en chambre
                        chambre.setLocal(chambre);
                        // on ajoute cette chambre dans la liste des locaux
                        service.createLocal(chambre); 
                        System.out.println("\n ( .. ) La chambre est bien ajoutee ! ( .. ) \n ");
                        System.out.println("\n ( .. ) Affichage des donnees de la chambre ajoutee ( .. ) \n ");
                        // on affiche les infos de la chambre créée
                        System.out.println(chambre.afficher());
                                               
                        
                    }else{ // on crée un appartement
                        
                        Local local = new Appartement();

                        // On récupere les donnees de l'appartement à creer en controlant ce que l'utilisateur a saisi

                    	String ref = local.getRef();

                        String localisation;
                        do{
                            System.out.print("Veuillez entrer la localisation : ");
                            localisation = scanner.nextLine();
                        }while(ClValidator.isNotEmpty(localisation)!=true || ClValidator.isString(localisation)!=true);

                        String StrPrix;
                            do{
                            System.out.print("Merci de saisir le prix : ");
                            StrPrix = scanner.nextLine();
                            }while(ClValidator.isNumeric(StrPrix)!=true);
                        int prix = Integer.parseInt(StrPrix);

                        String StrTaux;
                            do{
                            System.out.print("Merci de saisir le taux locatif : ");
                            StrTaux = scanner.nextLine();
                            }while(ClValidator.isNumeric(StrTaux)!=true);
                        int tauxLoc= Integer.parseInt(StrTaux);
                        
                        String StrNombrePieces;
                            do{
                            System.out.print("Merci de saisir le nombre de pieces : ");
                            StrNombrePieces = scanner.nextLine();
                            }while(ClValidator.isNumeric(StrNombrePieces)!=true);
                        int nombrePieces= Integer.parseInt(StrTaux);   
                        
                        String type = "appartement";

                        // instanciation et hydratation de l'appartement créée



                        Local appartement = new Appartement(ref, localisation, prix, tauxLoc, type, nombrePieces);
                        //on modifie le local en appartement
                        appartement.setLocal(appartement);
                        // on ajoute cette chambre dans la liste des locaux
                        service.createLocal(appartement);
                        System.out.println("\n ( .. ) L'appartement est bien ajoute ! ( .. ) \n ");
                        System.out.println("\n ( .. ) Affichage des donnees de l'appartement ajoute ( .. )");
                        // on affiche les infos de la chambre créée
                        System.out.println(appartement.afficher());
                    }
                break;
            case 2: // on liste les locaux par type => l'utilisateur choisi son type => on parcourt la liste des locaux et on affiche les locaux de ce type
              	 int typeLocal;

                System.out.println("\n ( .. ) Lister les locaux par type ( .. ) \n");
                do{
                    System.out.print(

                        "\n" +"Quel type de local veux tu lister : "
                        +"\n 1 - Chambre "
                        +"\n 2 - Appartement "
                		
                    );
                    typeLocal = Integer.parseInt(scanner.nextLine());
                }while(typeLocal !=1 && typeLocal !=2);
                if(typeLocal==1) {
                	Service.selectChambre(Service.listeLocal);
                }else{ 
                	Service.selectAppartement(Service.listeLocal);
                }
                break;
            case 3:// on liste les locaux reserve par un client : 
                    //On prend le nci du client, on parcourt la liste des reservation, on cherche les locaux qu'on a reserve et 
                    // et dont le nci du client qui l'a reservé = nci qu'on a saisi
                System.out.println("\n ( .. ) Lister les locaux reserves par un client ( .. ) \n");
                
                String nci;
                    do{
                    System.out.print("Merci de saisir nci du client veut voir ses reservations :");
                    nci = scanner.nextLine();
                    }while(ClValidator.isNci(nci)!=true);
                    
                Client client = Service.searchClient(nci);
                if( client != null) {
                	System.out.println("\n ( .. ) Bingo vous etes deja client ( .. ) \n");
                    System.out.println("\n ( .. ) Affichage des locaux que vous avez reserve ( .. ) \n");      		
                	Service.showLocalResByClient(nci);
                }else{
                    System.out.println("\n ( .. ) Vous n'etes pas encore client \n");
                }
                break;
            case 4: // Voir les détails d'un local
                //on recupere la reference du local, on cherche ce local dans la liste des locaux et on affiche ses details
                System.out.println("\n ( .. ) Voir les détails d'un local ( .. ) \n");
                System.out.println("\n ( .. ) Voici la liste des locaux disponibles ( .. ) \n");
                Service.selectLocal(Service.listeLocal);
                
                String refSearch;
                    do{
                        System.out.print("Veuillez entrer la reference du local concerne : ");
                        refSearch = scanner.nextLine();
                    }while(ClValidator.isNotEmpty(refSearch)!=true || ClValidator.isString(refSearch)!=true);

                Local loc = Service.searchLocal(refSearch);
                if( loc != null) {
                	System.out.println("Les details du local sont : ");      		
                	System.out.println(loc.afficher());
                }else {
                	System.out.println("\n ( .. ) La reference du local saisie n'existe pas ( .. ) \n");
                }
                break;
            case 5: // faire une reservation
                // on prend le nci du visiteur qui reserve
                // si le visiteur est deja client on le crée pas, sinon on le crée en prenant ses infos
                //on prend les infos de la reservation
                // on lui reserve le local
                // en creant la reservation qu'on met dans la liste des resrvations
                // en supprimant ce local dans la liste des locaux

                System.out.println("\n ( .. ) Faire reservation ( .. ) \n");
                
                do{
                System.out.print("Merci de saisir nci du client qui reserve un local :");
                nci = scanner.nextLine();
                }while(ClValidator.isNci(nci)!=true);

                client = Service.searchClient(nci);
                if( client != null) { // return != null => return client => client existe
                	System.out.println("\n ( .. ) Vous etes deja client ( .. ) \n");
                	System.out.println("Votre nom est : "+client.getNomComplet());
                }else { // return null => client n'existe pas => on le crée
                	System.out.println("\n ( .. ) Desole Mais vous n'etes pas client ( .. ) \n");
                    System.out.println("\n ( .. ) On vous inscrit en tant que client d'abord ( .. ) \n");
                    System.out.println("\n ( .. ) \t \t Inscription  ( .. ) \t \t \n");
                // on prend les infos du client à créer
                    String nomComplet;
                        do{
                            System.out.print("Veuillez entrer votre nom Complet : ");
                            nomComplet = scanner.nextLine();
                        }while(ClValidator.isNotEmpty(nomComplet)!=true || ClValidator.isString(nomComplet)!=true);

                    String tel;
                        do{
                            System.out.print("Merci de saisir votre numéro de telephone : ");
                            tel = scanner.nextLine();
                            }while(ClValidator.isTel(tel)!=true);

                    String adresse;
                        do{
                            System.out.print("Mercide saisir votre adresse : ");
                            adresse = scanner.nextLine();
                        }while(ClValidator.isNotEmpty(adresse)!=true || ClValidator.isString(adresse)!=true);

                    String email;
                        do{
                            System.out.print("Merci de saisir votre email :");
                            email = scanner.nextLine();
                            }while(ClValidator.isMail(email)!=true);
                    // on instancie le client
                    client = new Client(nci, nomComplet, tel, adresse, email);
                    //on crée ce client en l'ajoute dans la liste des clients
                    service.createClient(client);
                	System.out.println("\n ( .. ) Client cree et inscrit avec succes ( .. ) \n");
                }
                // si il était client, il l'est toujours, s'il n'étatit pas client on vient de le crée
                // Mais à ce niveau il est forcémént client
                // on affiche les locaux dispo pour qu'il puisse faire son choix
                System.out.println("\n ( .. ) Affichage de la liste des locaux disponibles ( .. ) \n");
                Service.selectLocal(Service.listeLocal);
                // on prend les infos de la reservation
                    do{
                        System.out.print("Veuillez entrer la reference du local a reserver :");
                        refSearch = scanner.nextLine();
                    }while(ClValidator.isNotEmpty(refSearch)!=true || ClValidator.isString(refSearch)!=true);

                loc = Service.searchLocal(refSearch);
                if( loc != null) {
                	System.out.println("Les details du local que vous souhaitez reserver : ");      		
                	System.out.println(loc.afficher());
                    System.out.println("\n ( .. ) Enregistrons les infos de la reservation maintenant ( .. ) \n");
                    
                    String dure;
                        do{
                            System.out.print("Merci de saisir la dure de la reservation : ");
                            dure = scanner.nextLine();
                        }while(ClValidator.isNotEmpty(dure)!=true || ClValidator.isString(dure)!=true);

                    String etat;
                        do{
                            System.out.print("Merci de saisir l'etat de la reservation : ");
                            etat = scanner.nextLine();
                        }while(ClValidator.isNotEmpty(etat)!=true || ClValidator.isString(etat)!=true);
                    // on instancie une reservation 
                    Reservation reservation = new Reservation();
                    // on recupère l'id de la reservation
                    int id = reservation.getId();
                    // on recupere la date et l'heure exacte qu'il fait
                    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    System.out.println("\n ( .. ) La date de la reservation est : \n"+s.format(date));
                    // on hydrate maintenant cette reservation avec avec les données que le client vient de saisir
                    reservation = new Reservation(date, dure, etat, id, loc, client);
                    // on crée cette reservation en l'ajoutant dans la liste des reservations
                    service.createReservation(reservation);
                    // on supprime ce local reservé dans la liste des locaux
                    service.getListeLocal().remove(loc);
                    System.out.println("\n ( .. ) La reservation a ete faite avec succes ( .. ) \n");
                    System.out.println(reservation.toString(s.format(date),loc,client));
                }else {
                    System.out.println("\n ( .. ) La reference du local sisie n'existe pas ( .. ) \n");
                }
                break;
            case 6:// Annuler une reservation
                    //on affiche les reservations du client qui souhaite annuler une reservation
                    // le client met le id de la reservation à annuler
                    // on recupere cette reservation
                    // on la supprime de la liste des reservation
                    // on remet le local concerne dans la liste des locaux pour kil soit dispo de nouveau
            System.out.println("\n ( .. ) Annuler une reservation ( .. ) \n");
            
            do{
                System.out.print("Merci de saisir nci du client qui annule sa reservation : ");
                nci = scanner.nextLine();
                }while(ClValidator.isNci(nci)!=true);

            client = Service.searchClient(nci);
            if( client != null) {// s'il est client
                System.out.println("\n ( .. ) Vous etes deja client ( .. ) \n");
                System.out.println("\n ( .. ) Affichage de vos reservations ( .. ) \n");
                Service.showLocalResByClient(nci);

                String strId;
                    do{
                        System.out.print("Merci de saisir l'id de reservation a annuler : ");
                        strId = scanner.nextLine();
                        }while(ClValidator.isNumeric(strId)!=true);
                int id = Integer.parseInt(strId);

                Reservation reservation = Service.searchReservation(id);
                if(reservation != null){// si la reservation existe pour ce client
                    Service.deleteReservation(reservation);// on supprime la reservation concernee
                    service.createLocal(reservation.getLocal());// on rend le local qu'on avit reservé dispo en le mettant dans la liste des locaux
                    System.out.println("\n ( .. ) Reservation d'id "+id+ " a été annulée ( .. ) \n");

                }else{
                    System.out.println("\n ( .. ) l'id de la reservation saisie n'existe pas ( .. ) \n");
                }
            }else{
                System.out.println("\n ( .. ) Vous n'etes pas client ( .. ) \n");
            
            }
                break;
            case 7:// lister les locaux disponible
                //on affiche la liste des locaux disponibles : non reservé : on affiche la liste des locaux
            System.out.println("\n ( .. ) Lister les locaux disponibles ( .. ) \n");
            Service.selectLocal(Service.listeLocal);
                break;
            case 8:// Quitter : on affiche bye bye
                System.out.println(" Bye Bye ( .. ) "); 
                break;
            default:
                System.out.println("Mauvais choix : \n Veuillez choisir la bonne option SVP ");
            }
            
        } while (choix != 8);
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
        String StrChoix;
            do{
            System.out.print("Merci de faire votre choix : ");
            StrChoix = scanner.nextLine();
            }while(ClValidator.isNumeric(StrChoix)!=true);
        choix = Integer.parseInt(StrChoix);
        return choix;
}

}