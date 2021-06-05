package gestion.reservation;

import java.util.ArrayList;
import java.util.List;

public class Client {
    
    private String nci;
    public String nomComplet;
    public String tel;
    public String adresse;
    public String email;

    // Dans client on peut avoir une table de reservation
    //private List<Reservation> listeReservation = new ArrayList<>();
    
    
    private List<Reservation> listeReservation;

    
    


    // getters et setters 



	public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
            this.nci = nci;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {      
            this.nomComplet = nomComplet;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {

            this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {

            this.adresse = adresse;
    }
    

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
    
            this.email = email;

    }
    
    
    public List<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}
	


    // les autres attributs sont à public donc getters et setters non obligatoire pour les manipuler

    //constructeurs : 
    public Client(){

    }

    public Client(String nci, String nomComplet, String tel, String adresse, String email){

        setNci(nci);
        setNomComplet(nomComplet);
        setTel(tel);
        setAdresse(adresse);
        setEmail(email);
        
    }
}

