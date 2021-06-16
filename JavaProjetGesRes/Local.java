import java.util.List;
public class Local{

    // Attributs de Local
    protected String ref;
    protected String localisation;
    protected int prix;
    protected int tauxLoc;
    protected String type;
    // Attributs navigationnel
    private Local local;
    private List<Reservation> listeReservation;


    // getters et setters : 

    //générer la réference suivant le format : Ref-CCCC 
    public  String generateRef(){

        char[] tabCar = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int index1 = (int)Math.round(Math.random()*25);
        int index2 = (int)Math.round(Math.random()*25);
        int index3 = (int)Math.round(Math.random()*25);
        int index4 = (int)Math.round(Math.random()*25);
        return "Ref-"+tabCar[index1]+tabCar[index2]+tabCar[index3]+tabCar[index4];
       
    }

    // getters et setters
    
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
    	return ("\n ( .. ) Informations du local ( .. ) \n"
        +"Reference : "+getRef()
        +"\n Localisation : "+getLocalisation()
        +"\n Prix : "+getPrix()
        +"\n Taux locatif : "+getTauxLoc()+"%"
        +"\n Type : "+getType());
    }


    
    
    
}
