package sn.lamp.metier;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import sn.lamp.Bean.PostBean;

public class POSTFrom {
	public static final String VUE          = "/WEB-INF/new_post.jsp";
    public static final String CHAMP_DATE  = "date";
    public static final String CHAMP_AUTEUR   = "auteur";
    public static final String CHAMP_TITRE   = "titre";
    public static final String CHAMP_CONTTENU   = "contenu";
    public static final String CHAMP_PROFIL   = "profil";
    public static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    private String resultat;
    Map<String, String> erreurs = new HashMap<String, String>();
    public PostBean nouveauPost	( HttpServletRequest request ) {
        String date = getValeurChamp( request, CHAMP_DATE );
        String titre = getValeurChamp( request, CHAMP_TITRE );
        String auteur = getValeurChamp( request, CHAMP_AUTEUR );
        String contenu = getValeurChamp( request, CHAMP_CONTTENU);
       

        PostBean test = new PostBean();

      try {
		 validationAuteur(auteur);
	} catch (Exception e) {
		// TODO: handle exception
		setErreurs(CHAMP_AUTEUR, e.getMessage());
	}
      test.setAuteur(auteur);
      try {
 		 validationContenu(contenu);
 	} catch (Exception e) {
 		// TODO: handle exception
 		setErreurs(CHAMP_CONTTENU, e.getMessage());
 	}
  
      test.setContenu(contenu);
      try {
 		 validationTitre(titre);
 	} catch (Exception e) {
 		// TODO: handle exception
 		setErreurs(CHAMP_TITRE, e.getMessage());
 	}
      test.setTitre(titre);
      try {
 		 validationDate(date);
 	} catch (Exception e) {
 		// TODO: handle exception
 		setErreurs(CHAMP_DATE, e.getMessage());
 	}
      test.setDate(date);

        return test;
    }

private void validationAuteur( String auteur ) throws Exception {
        if ( auteur != null ) {
        	
            
        }else {
        	throw new Exception( "Le nom D'auteur est obligatoire." );
        }
    }
    private void validationDate( String date ) throws Exception {
        if ( date == null ) {
        	
        		throw new Exception( "La Date de la pulication est Obligatoire ." );
        }
    }
	private void validationTitre( String titre ) throws Exception {
        if ( titre == null ) {
        	
        		throw new Exception( "Le titre de la pulication est Obligatoire ." );
        }
    }
	private void validationContenu( String contenu ) throws Exception {
        if ( contenu == null ) {
        	
        		throw new Exception( "Le Contenu de la pulication est Obligatoire." );
        }
    }
   
 
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    public void setErreurs( String champ, String message ) {
        erreurs.put( champ, message );
    }


    public Map<String, String> getErreurs() {
    	return erreurs;
    }



    public String getResultat() {
    	return resultat;
    }


    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }


	
}
