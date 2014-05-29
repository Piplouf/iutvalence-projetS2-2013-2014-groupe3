package fr.projetS2_2013_2014_groupe3.jeu;

import fr.projetS2_2013_2014_groupe3.competences.BouleDeFeu;
import fr.projetS2_2013_2014_groupe3.competences.Competence;
import fr.projetS2_2013_2014_groupe3.objets.PotionDeDeplacement;
import fr.projetS2_2013_2014_groupe3.objets.PotionDeSoin;


public class Joueur {
	
	private Sac sac;
	
	private Personnage[] equipe;
	
	private int numero;
	
	public final static int NOMBRE_DE_PERSONNAGES_PAR_EQUIPE = 4;
	
	private static int nombreJoueurs = 1;
	
	public Joueur(){
		
		this.sac = new Sac();
		this.equipe = new Personnage[NOMBRE_DE_PERSONNAGES_PAR_EQUIPE];
		this.numero = nombreJoueurs++;
		
		this.sac.ajouterObjet(new PotionDeSoin(50), 10);
		this.sac.ajouterObjet(new PotionDeDeplacement(2), 5);
		
	}
	
	public Joueur(Personnage[] persoVoulus, int numero){
		this.sac = new Sac();
		this.equipe = new Personnage[NOMBRE_DE_PERSONNAGES_PAR_EQUIPE];
		this.numero = numero;
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
	
	public void ajouterEquipe(Personnage[] equipeDePerso){
		this.equipe = equipeDePerso;
	}
	
	public Personnage[] obtenirPersonnageDUneEquipe(){
		return this.equipe;
	}
	
	public Personnage obtenirPersonnage(int numeroPerso){
		return this.equipe[numeroPerso];
	}
	
	public boolean ajouterJoueur(Personnage perso){
		
		int i = 0;
		while(this.equipe[i++] instanceof Personnage){
			if( i == 4)
				break;
		}
		if(i < 4){
			this.equipe[i] = perso;
			return true;
		}
		else 
			return false;
		
	}
	

}
