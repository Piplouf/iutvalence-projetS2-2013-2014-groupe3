package fr.projetS2_2013_2014_groupe3.jeu;


public class Case {
	
	private boolean estPleine;
	
	private Perso estOccupe;
	
	private int numeroJoueur;

	public Case(){
		this.estOccupe = new PersonnageVide();
		this.estPleine = false;
		this.numeroJoueur = 0;
	}
	
	public Case(Personnage perso, int num){
		this.estOccupe = perso;
		this.estPleine = false;
		this.numeroJoueur = num;
	}
	
	public Case(boolean estPleine){
		this.estOccupe = new PersonnageVide();
		this.estPleine = estPleine;
		this.numeroJoueur = 0;
	}
	
	/**
	 * Renvoi true si la case est pleine
	 * et false si elle ne l'est pas
	 */
	
	public void enleverPersonnage(){
		this.modifierEstOccupe(new PersonnageVide());
		this.numeroJoueur = 0;
	}
	
	public void ajouterPersonnage(Personnage perso, int numeroJoueur){
		this.modifierEstOccupe(perso);
		this.numeroJoueur = numeroJoueur;
	}
	
	public boolean estPleine(){
		return this.estPleine;
	}
	
	/**
	 * Renvoi true si la case est occupe par un personnage
	 * et false si elle n'est pas occupe
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
}


