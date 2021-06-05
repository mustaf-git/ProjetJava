package gestion.reservation;

import java.util.ArrayList;
import java.util.List;

public class Appartement extends Local implements ICout {
    
    // Attribut de la classe Appartement 
    private int nombrePieces;

    // Attribut navigationnel
    // Dans Appartememnt on a une liste de local de type chambre : liste de chambre
    //private List<Chambre> listChambre = new ArrayList<>();
    
    private List<Chambre> listChambre;
    

    // getters et setters
    public int getNombrePieces(){
        return nombrePieces;
    }
    
    public void setNombrePieces(int nombrePieces){
        this.nombrePieces = nombrePieces;
    }

    public List<Chambre> getListChambre() {
        return listChambre;
    }
    public void setListChambre(List<Chambre> listChambre) {
        this.listChambre = listChambre;
    }

    //constructeurs : 
    public Appartement(){

    }
    public Appartement(String ref, String localisation, int prix, int tauxLoc, String type, int nombrePieces){
        super(ref, localisation, prix, tauxLoc,type);
        this.setNombrePieces(nombrePieces);
    }

    // redéfinition de la fonction cout 
    @Override
    public double cout() {
        
        return prix + (prix * tauxLoc)/100;
    }
    
    public String afficher() {
    	return super.afficher()
		+"\n nombre de pieces : "+getNombrePieces();
    }


}




