package fr.projetS2_2013_2014_groupe3.jeu;


public class Partie {
	
	private Joueur[] joueur;
	
	private Carte carte;
	
	private int numeroJoueurTour;
	
	public Partie(){
		this.joueur = new Joueur[2];
		this.joueur[0] = new Joueur();
		this.joueur[1] = new Joueur();
		this.numeroJoueurTour = 1;
	}
	
	public void ajouterCarte(Carte carte){
		this.carte = new Carte(carte.obtenirCarte());
	}
	
	public void ajouterPersonnage(Personnage perso){
		this.joueur[0].ajouterJoueur(perso);
	}
	
	public boolean ajouterPersonnage(Personnage perso, int num){
		 return(this.joueur[num].ajouterJoueur(perso));
	}
	
	public void commencerPartie(){
		
		
		Position posiDep = new Position(0,0);
		
		for(Personnage perso: this.joueur[0].obtenirPersonnageDUneEquipe()){
			this.carte.placerPersonnage(posiDep, perso);
			posiDep.modifierY(posiDep.obtenirY() + 2);
		}
		
		posiDep.modifierX(7);
		posiDep.modifierY(1);
		for(Personnage perso: this.joueur[1].obtenirPersonnageDUneEquipe()){
			this.carte.placerPersonnage(posiDep, perso);
			posiDep.modifierY(posiDep.obtenirY() + 2);
		}
		this.carte.afficherCarte();
	
	}
	
	public Joueur obtenirJoueur(int num){
		return this.joueur[num];
	}
	
	public Carte obtenirCarte(){
		return this.carte;
	}
	
	public Joueur obtenirJoueurCourant(){
		return this.obtenirJoueur(this.obtenirNumJoueur() - 1);
	}
	
	public int obtenirNumJoueur(){
		return this.numeroJoueurTour;
	}
	
	public void modifierNumeroJoueur(){
		if(this.numeroJoueurTour == 1)
			this.numeroJoueurTour = 2;
		else
			this.numeroJoueurTour = 1;
	}
	
	public int obtenirNumeroJoueurInverse(){
		if(this.numeroJoueurTour == 1)
			return 2;
		else
			return 1;
	}
	
}
