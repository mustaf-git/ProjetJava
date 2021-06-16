import java.util.List;

public class Appartement extends Local implements ICout {
    // Attributs de Appartement
    private int nombrePieces;
    // attribut navigationnel
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

    // redéfinition de la fonction cout (Local)
    @Override
    public double cout() {
        
        return prix + (prix * tauxLoc)/100;
    }
    
    // redefinition de la foncion afficher (Local)
    @Override
    public String afficher() {
    	return super.afficher()
		+"\n nombre de pieces : "+getNombrePieces()
        +"\n Cout : "+cout();
    }


}





