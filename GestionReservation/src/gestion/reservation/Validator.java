package gestion.reservation;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Validator {
    
    //validation du mail : 

    public static boolean mailEstValide(String email){

        String expRegMail = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.([a-z]{2,}|[a-z]\\.[a-z]{2,})$";
        //String expRegMail2 = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z]\\.[a-z]{2,}$";

        return (email.matches(expRegMail));

    }

    // validation du numéro de téléphone sous forme : 
    // 33 ou 70 ou ou 75 ou 76 ou 77 ou 787236898

    public static boolean numeroEstValide(String tel){

        String expRegnumero = "^(3[3]|7[0]|7[5-8])[0-9]{7}$";
        return(tel.matches(expRegnumero));

    }


    // validation du nci : 
    // commence par (1 -> homme ou par 2 -> femme ) sur 13 chiffres
    

    public static boolean nciEstValide(String nci){

        String expRegnci = "^(1[0-9]{12}|2[0-9]{12})$";
        return(String.valueOf(nci).matches(expRegnci));

    }

    // validation du nom complet : 

    public static boolean nomCompletEstValide(String nomComplet){
        String expRegNomComplet = "^[A-Za-z0-9_-. ]$";
        return (nomComplet.matches(expRegNomComplet));
    }

    // validation de l'adresse
    public static boolean adresseEstValide(String adresse){
        String expRegAdresse = "^[A-Za-z0-9._@x*- ]$";
        return (adresse.matches(expRegAdresse));
    }

    // validation de la date 
 
    public static boolean dateIsValid(String strdate, String format) {

        SimpleDateFormat df = new SimpleDateFormat(format); // un objet df qui instancie le format de la date passé en pramettre
        df.setLenient(false); // les dates possibles
        try {
            Date date = df.parse(strdate); // conversion de strdate en format de df qu'on veut et stocké ça dans date
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }


    // validation de la dure 
 
    public static boolean dureIsValid(String dure) {
        String expRegDure = "^[0-9]+[A-Za-z -]+$";
        return dure.matches(expRegDure);
    }

    
    // validation du nombre de pieces 

    public static boolean nbrePieceValide(int nombrePieces){

        String expRegNbrePiece = "^[0-9]+$";
        return String.valueOf(nombrePieces).matches(expRegNbrePiece);
        
    }


    // validation nombre de dimension
    public static boolean dimensionIsValid(String dimension){
            String expRegDimension = "^[0-9]+[A-Za-z]+$";
            return dimension.matches(expRegDimension);
    }




    // protected double tauxLoc;
    // protected String type;

    // Validation de la localisation
    public static boolean localisationIsValid(String localisation){

        String expRegLoc = "^[A-Za-z0-9._@x- ]$";
        return (localisation.matches(expRegLoc));

    }

    // validation du prix
    public static boolean prixIsValid(int prix){

        return String.valueOf(prix).matches("^[0-9]+$");
    }


    // validation de l'etat
    public static boolean etatIsValid(String etat){

        return etat.matches("^reservé|en cours|annulé$");
    }


    // validation du type
    public static boolean typeIsValid(String type){

        return type.matches("^chambre|appartement$");
    }

    // validation du tauxLoc
    public static boolean tauxLocIsValid(int tauxLoc){

        return (String.valueOf(tauxLoc).matches("^[0-9]+$")) && (tauxLoc < 100);
    }




}

