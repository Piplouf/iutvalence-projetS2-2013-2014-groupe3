package fr.projetS2_2013_2014_groupe3.jeu;

import fr.projetS2_2013_2014_groupe3.exceptions.NumeroJoueurErronne;
import fr.projetS2_2013_2014_groupe3.exceptions.PositionErronne;


public class Case {
	
	private boolean estPleine;
	
	private Perso estOccupe;
	
	private int numeroJoueur;
	
	private Position position;

	public Case(Position position) throws PositionErronne{
		this.estOccupe = new PersonnageVide();
		this.estPleine = false;
		this.numeroJoueur = 0;
		if(position.obtenirX() < 0 || position.obtenirY() < 0)
			throw new PositionErronne();
		else
			this.position = position;
	}
	
	public Case(Personnage perso, int num, Position position) throws PositionErronne, NumeroJoueurErronne{
		this.estOccupe = perso;
		this.estPleine = false;
		if(position.obtenirX() < 0 || position.obtenirY() < 0)
			throw new PositionErronne();
		else
			this.position = position;
		if(num != 1 && num != 2)
			throw new NumeroJoueurErronne();
		else
			this.numeroJoueur = num;
	}
	
	public Case(boolean estPleine, Position position) throws PositionErronne{
		this.estOccupe = new PersonnageVide();
		this.estPleine = estPleine;
		if(position.obtenirX() < 0 || position.obtenirY() < 0)
			throw new PositionErronne();
		else
			this.position = position;
		this.numeroJoueur = 0;
	}
	

	/** Permet de retirer un personnage d'une case*/
	public void enleverPersonnage(){
		this.modifierEstOccupe(new PersonnageVide());
		this.numeroJoueur = 0;
	}
	
	/** Permet d'ajouter un personnage sur une case */
	public void ajouterPersonnage(Personnage perso, int numeroJoueur){
		this.modifierEstOccupe(perso);
		this.numeroJoueur = numeroJoueur;
	}
	
	/**
	 * Renvoi true si la case est pleine
	 * et false si elle ne l'est pas
	 */
	public boolean estPleine(){
		return this.estPleine;
	}
	
	/**
	 * Renvoi le personnage si la case est occupe par un personnage
	 * et le personnage vide si elle n'est pas occupe
	 * @return
	 */
	public Perso estOccupe(){
		return this.estOccupe;
	}
	
	public int obtenirNumeroJoueur(){
		return this.numeroJoueur;
	}
	
	public void modifierEstPleine(boolean modif){
		this.estPleine = modif;
	}
	
	public void modifierEstOccupe(Perso perso){
			this.estOccupe = perso;
	}
	
	public Position obtenirPosition(){
		return this.position;
	}
}


