package gestion.reservation;

import java.util.Date;

public class Reservation {
    
    //attributs de la classe reservation
    private Date date;
    private String dure;
    private String etat;
    private int id;
    public static int idGenere ;
    
    //Attribut navigationnel :

    // On a un local dans reservation 
    private Local local;

    // Dans r�servation on peut avoir des objets de type chambre :
    //private Local chambre = new Chambre();
   // private Local chambre;



	// Dans r�servation on peut avoir des objets de type appartement
    //private Local appartement = new Appartement();
    //private Local appartement;


    
   

	// Dans r�servation on peut avoir un client
    //private Client client = new Client();
    private Client client;
    
    
    
    

    //getters et setters
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public String getDure() {
        return dure;
    }
    public void setDure(String dure) {
        this.dure = dure;
    }

    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    /*
     public Local getChambre() {
		return chambre;
	}

	public void setChambre(Local chambre) {
		this.chambre = chambre;
	}

	public Local getAppartement() {
		return appartement;
	}

	public void setAppartement(Local appartement) {
		this.appartement = appartement;
	}
	*/
    
    public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
    //constructeurs 
    public Reservation(){
        id = ++ idGenere;
    }

    public Reservation(Date date, String dure, String etat, int id, Local local, Client client){
        this.setDate(date);
        this.setDure(dure);
        this.setEtat(etat);
        this.setId(id);
        this.setLocal(local);
        this.setClient(client);
    }

    public String toString(String dateAct, Local local, Client client){
        StringBuilder sb = new StringBuilder();
        sb.append("le client : \n "+"nom Complet : "+client.getNomComplet()+" - nci : "+client.getNci()+"\n"); 
        sb.append("la reference du local reservé : "+local.getRef()+"\n"); 
        sb.append("id : "+getId()+"\n");
        sb.append("Etat : "+getEtat()+"\n");
        sb.append("date : "+dateAct+"\n");
        sb.append("dure : "+getDure()+"\n");
        return sb.toString();
    }

    
    


}

