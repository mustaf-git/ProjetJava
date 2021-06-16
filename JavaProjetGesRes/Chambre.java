public class Chambre extends Local implements ICout{
    //Attribut de Chambre
    private String dimension;

    
    // getters et setters : 
    public String getDimension() {

        return dimension;
    }

    public void setDimension(String dimension) {

        this.dimension = dimension;
    }

    //constructeurs : 
    
    public Chambre(){

    }

    public Chambre(String ref, String localisation, int prix, int tauxLoc, String type, String dimension){

        super(ref, localisation, prix, tauxLoc, type);
        this.setDimension(dimension);

    }

    //redéfinition de la fonction cout 
    @Override
    public double cout(){
        return prix +(prix * tauxLoc)/100;
    }
    
    // redefinition de la foncion afficher (Local)
    @Override
    public String afficher() {
    	return super.afficher()
		+"\n Dimension : "+getDimension()
        +"\n Cout : "+cout();
    }
}

