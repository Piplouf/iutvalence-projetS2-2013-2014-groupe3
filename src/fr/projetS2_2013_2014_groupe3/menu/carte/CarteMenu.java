package fr.projetS2_2013_2014_groupe3.menu.carte;
import javax.swing.ImageIcon;

import fr.projetS2_2013_2014_groupe3.jeu.Carte;


public class CarteMenu {
	
	private Carte carte;
	
	private ImageIcon image;
	
	public CarteMenu(){
		this.carte = new Carte();
		this.image = new ImageIcon("");
	}
	
	public CarteMenu(Carte carteChoisi, ImageIcon img){
		
		this.carte = carteChoisi;
		this.image = img;
	}
	
	public Carte obtenirCarte(){
		return this.carte;
	}

}
