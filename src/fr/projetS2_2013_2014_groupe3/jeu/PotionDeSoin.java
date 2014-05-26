package fr.projetS2_2013_2014_groupe3.jeu;


public class PotionDeSoin extends Objet {
	
	private int quantiteSoin;
	
	public PotionDeSoin(int quantite){
		super ("Potion de soin", TypeObjet.DEFENSIF);
		this.quantiteSoin = quantite;
	}
	
	public String utiliserObjet(Personnage perso){
		return "";
	}
	
	public int obtenirQuantité(){
		return this.quantiteSoin;
	}
}

