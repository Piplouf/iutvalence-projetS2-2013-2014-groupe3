package fr.projetS2_2013_2014_groupe3.jeu;

/** Partie du jeu */
public class Partie {

	private Joueur[] joueur;

	private Carte carte;

	private int numeroJoueurTour;

	/**
	 * Créer une partie avec deux joueur et en initialisant le joueur a joué au
	 * joueur 1
	 */
	public Partie() {
		this.joueur = new Joueur[2];
		this.joueur[0] = new Joueur();
		this.joueur[1] = new Joueur();
		this.numeroJoueurTour = 1;
	}

	/** Permet de rajouter une carte à la partie */
	public void ajouterCarte(Carte carte) {
		this.carte = new Carte(carte.obtenirCarte());
	}

	/**
	 * Vérifie les etats de chaque personnage et gére l'effet de ceux-ci sur les
	 * personnages
	 */
	public void verifierEtatEtModifierPersonnageEnConsequence() {

		for (int i = 0; i < 2; i++) {
			for (Personnage perso : this.joueur[i]
					.obtenirPersonnageDUneEquipe()) {
				if (perso.obtenirEtat() == Etat.EMPOISONNE) {
					perso.enleverVie(5);
					perso.decrementerNombreDeTourEtat();
					if (perso.obtenirNombreDeTourEtat() == 0)
						perso.modifierEtat(Etat.NORMAL);
				}
			}
		}
	}

	/** Redonne un montant de 5 d'energie à tous les personnages */
	public void redonnerEnergieATousLesPersonnages() {

		for (int i = 0; i < 2; i++) {
			for (Personnage perso : this.joueur[i]
					.obtenirPersonnageDUneEquipe())
				perso.remonterEnergie();
		}
	}

	public Joueur obtenirJoueur(int num) {
		return this.joueur[num];
	}

	public Carte obtenirCarte() {
		return this.carte;
	}

	public Joueur obtenirJoueurCourant() {
		return this.obtenirJoueur(this.obtenirNumJoueur() - 1);
	}

	public int obtenirNumJoueur() {
		return this.numeroJoueurTour;
	}

	public void modifierNumeroJoueur() {
		if (this.numeroJoueurTour == 1)
			this.numeroJoueurTour = 2;
		else {
			this.numeroJoueurTour = 1;
			this.verifierEtatEtModifierPersonnageEnConsequence();
		}
	}

	/** Vérifie si un joueur a gagné la partie et renvoi true si c'est le cas */
	public boolean estGagnee() {

		boolean estGagnee = true;
		for (Personnage perso : this.joueur[0].obtenirPersonnageDUneEquipe()) {
			if (perso.obtenirVie() != 0)
				estGagnee = false;
		}
		if (estGagnee == false) {
			estGagnee = true;
			for (Personnage perso : this.joueur[1]
					.obtenirPersonnageDUneEquipe()) {
				if (perso.obtenirVie() != 0)
					estGagnee = false;
			}
		}

		return estGagnee;
	}

	public int obtenirNumeroJoueurInverse() {
		if (this.numeroJoueurTour == 1)
			return 2;
		else
			return 1;
	}

}
