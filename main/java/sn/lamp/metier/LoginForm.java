package sn.lamp.metier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import sn.lamp.Bean.InscriptionBean;


public class LoginForm {
	public static final String VUE          = "/WEB-INF/inscription.jsp";
    
    public static final String CHAMP_PASS   = "password";
  
    public static final String CHAMP_LOGIN   = "login";
   
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
private static final long serialVersionUID = 1803743077551873646L;
   public static final String SUCCES= "/WEB-INF/connexion.jsp";
private String resultat;
Map<String, String> erreurs = new HashMap<String, String>();

InscriptionBean log=new InscriptionBean();
public InscriptionBean loginUtilisateur( HttpServletRequest request ) {

    String motDePasse = getValeurChamp( request, CHAMP_PASS );
    String login = getValeurChamp( request, CHAMP_LOGIN );


  

    try {
        validationLogin( login );
    } catch ( Exception e ) {
        setErreurs( CHAMP_LOGIN, e.getMessage() );
    }
    log.setLogin( login );

    try {
        validationMotsDePasse( motDePasse );
    } catch ( Exception e ) {
        setErreurs( CHAMP_PASS,e.getMessage() );
       
    }
    log.setMot_de_passe(motDePasse);
    if ( erreurs.isEmpty() ) {
        resultat= SUCCES;
     } else {
         resultat = VUE;
     }

     return log;
 }


	private void validationLogin( String login ) throws Exception {
		  if ( login != null ) {
			  if ( login.length()<5 ) {
		            throw new Exception( "Merci de saisir une adresse mail valide." );
		        
		    	}
		        
		    }else {
		    	throw new Exception( "Le login d'utilisateur est obligatoire." );
		    }
	}
	private void validationMotsDePasse( String motDePasse) throws Exception {
	    if ( motDePasse != null  ) {
	        if ( motDePasse.length()<7 ) {
	            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	        } 
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}
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
