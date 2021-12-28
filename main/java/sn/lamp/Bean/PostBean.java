package sn.lamp.Bean;

public class PostBean {
	private int id;
private String titre;
private String Date;
private String contenu;
private String auteur;

public PostBean() {
	// TODO Auto-generated constructor stub
}

public PostBean(int id, String titre, String date, String contenu, String auteur) {
	super();
	this.id = id;
	this.titre = titre;
	Date = date;
	this.contenu = contenu;
	this.auteur = auteur;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public String getContenu() {
	return contenu;
}
public void setContenu(String contenu) {
	this.contenu = contenu;
}
public String getAuteur() {
	return auteur;
}
public void setAuteur(String auteur) {
	this.auteur = auteur;
}

}
