package gestion.reservation;
import java.util.ArrayList;
import java.util.List;
public class Local{

    // Atribut de la classe local
    protected String ref;
    protected String localisation;
    protected int prix;
    protected int tauxLoc;
    protected String type;

    // Attribut navigationnel

    // Dans un local on peut avoir un objet de type appartement
    //private Appartement appartement = new Appartement();
    private Local local;


	// Dans un local on peut avoir un tableau de type de reservation
    //private List<Reservation> listeReservation = new ArrayList<>();
    private List<Reservation> listeReservation;


    // getters et setters : 

    //g�n�rer la r�ference suivant le format : Ref-CCCC 
    public  String generateRef(){

        char[] tabCar = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int index1 = (int)Math.round(Math.random()*25);
        int index2 = (int)Math.round(Math.random()*25);
        int index3 = (int)Math.round(Math.random()*25);
        int index4 = (int)Math.round(Math.random()*25);
        return "Ref-"+tabCar[index1]+tabCar[index2]+tabCar[index3]+tabCar[index4];
       
    }

public  String getRef(){
    return ref;
}

public void setRef(String ref){
this.ref = ref;
}
    

    public String getLocalisation(){
        return localisation;
    }

    public void setLocalisation(String localisation){
        this.localisation = localisation;
    }

    public int getPrix(){
        return prix;
    }

    public void setPrix(int prix){
        this.prix = prix;
    }

    public double getTauxLoc(){
        return tauxLoc;
    }

    public void setTauxLoc(int tauxLoc){
        this.tauxLoc = tauxLoc;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
    
    
    public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
	}


    public List<Reservation> getListeReservation() {
        return listeReservation;
    }

    public void setListeReservation(List<Reservation> listeReservation) {
        this.listeReservation = listeReservation;
    }

    // constructeurs : 
    public Local(){

        ref = generateRef();
    }

    public Local(String ref, String localisation, int prix, int tauxLoc, String type){
        this.ref = generateRef();
        this.setLocalisation(localisation);
        this.setPrix(prix);
        this.setTauxLoc(tauxLoc);
        this.setType(type);
    }
    
    public String afficher() {
    	return ( "\n Reference : "+getRef()
    			+"\n Localisation : "+getLocalisation()
    			+"\n Prix : "+getPrix()
    			+"\n Taux locatif : "+getTauxLoc()+"%"
    			+"\n Type : "+getType());
    }
    
    
}
