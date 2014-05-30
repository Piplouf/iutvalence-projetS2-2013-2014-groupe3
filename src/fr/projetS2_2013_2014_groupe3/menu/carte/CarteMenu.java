package fr.projetS2_2013_2014_groupe3.menu.carte;
import javax.swing.ImageIcon;

import fr.projetS2_2013_2014_groupe3.jeu.Carte;

/** Classe propre à l'ihm comportant l'image associé à la carte qu'elle represente*/
public class CarteMenu {
	
	private Carte carte;
	
	private ImageIcon image;
	
	private String nom;
	
	public CarteMenu(){
		this.carte = new Carte();
		this.image = new ImageIcon("");
		this.nom = "";
	}
	
	public CarteMenu(Carte carteChoisi, ImageIcon img, String name){
		
		this.carte = carteChoisi;
		this.image = img;
		this.nom = name;
	}
	
	public String obtenirNom(){
		return this.nom;
	}
	
	public Carte obtenirCarte(){
		return this.carte;
	}
	
	public ImageIcon obtenirImage(){
		return this.image;
	}

}
