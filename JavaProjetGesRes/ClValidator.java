public class ClValidator {

    //  validation email
    public static boolean isMail(String email){

        String expRegMail = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.([a-z]{2,}|[a-z]\\.[a-z]{2,})$";
        return (email.matches(expRegMail));
    }

    // validation numero tel Senegal
    public static boolean isTel(String tel){
        String expRegnumero = "^(3[3]|7[0]|7[5-8])[0-9]{7}$";
        return(tel.matches(expRegnumero));
    }

    // validation nci Senegalais
    public static boolean isNci(String nci){
        String expRegnci = "^(1[0-9]{12}|2[0-9]{12})$";
        return (String.valueOf(nci).matches(expRegnci));
    }

// vlidation globale :
 
    // validation de toutes les saisies de type String

    // Controler les champs vides
    public static boolean isNotEmpty(String string){
        return (string.matches("^(?=\\s*\\S).*$"));
    }

    //  Chaine de caractères valide
    public static boolean isString(String string){
        String expRegString = "^[A-Za-z0-9 -]+$";
        return (string.matches(expRegString));
    }

    // Nombre valide
    public static  boolean isNumeric(String entier){
        String expRegDig = "\\d+";
        return(entier.matches(expRegDig));
    }





    






}

