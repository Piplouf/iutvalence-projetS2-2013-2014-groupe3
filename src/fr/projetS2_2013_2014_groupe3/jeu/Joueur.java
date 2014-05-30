package fr.projetS2_2013_2014_groupe3.jeu;

import fr.projetS2_2013_2014_groupe3.objets.PotionDeDeplacement;
import fr.projetS2_2013_2014_groupe3.objets.PotionDeSoin;

/** Joueur */
public class Joueur {
	
	/** Sac du joueur */
	private Sac sac;
	
	private Personnage[] equipe;
	
	private int numero;
	
	public final static int NOMBRE_DE_PERSONNAGES_PAR_EQUIPE = 4;
	
	private static int nombreJoueurs = 1;
	
	/** Constructeur par défaut du joueur créer une equipe vide et un sac contenant 10 potions de soin et 5 de déplacement*/
	public Joueur(){
		
		this.sac = new Sac();
		this.equipe = new Personnage[NOMBRE_DE_PERSONNAGES_PAR_EQUIPE];
		this.numero = nombreJoueurs++;
		
		this.sac.ajouterObjet(new PotionDeSoin(50), 10);
		this.sac.ajouterObjet(new PotionDeDeplacement(2), 5);
		
	}
	
	/**
	 * Renvoi l'attribut numero du joueur
	 */
	public int obtenirNumero(){
		return this.numero;
	}
	
	public Sac obtenirSac(){
		return this.sac;
	}
	
	/** Permet d'ajouter une equipe à un joueur*/
	public void ajouterEquipe(Personnage[] equipeDePerso){
		this.equipe = equipeDePerso;
	}
	
	/** Retournes tous les personnages d'une equipe */
	public Personnage[] obtenirPersonnageDUneEquipe(){
		return this.equipe;
	}
	
	public Personnage obtenirPersonnage(int numeroPerso){
		return this.equipe[numeroPerso];
	}
	

}
