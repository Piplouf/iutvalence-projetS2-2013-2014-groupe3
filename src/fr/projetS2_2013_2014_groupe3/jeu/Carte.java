package fr.projetS2_2013_2014_groupe3.jeu;


public class Carte {

	public static final int TAILLE_Y_DEFAUT = 8;
	public static final int TAILLE_X_DEFAUT = 8;
	
	private Case[][] carte;
	
	public Carte(){
		this.carte = null;
	}
	
	public Carte(Case[][] carteVoulue){
		this.carte = carteVoulue;
	}
	
	public Carte(Carte carte) {
		this.carte = new Case[carte.obtenirTailleEnX()][carte.obtenirTailleEnY()];
		this.carte = carte.carte;
	}

	/**
	 * Permet de deplacer le personnage
	 * @return 
	 */
	public boolean deplacerPersonnage(Position position, Personnage perso, int numeroJoueur){
		if(deplacementEstPossible(position) && nombreDeDeplacementEstSuffisant(position, perso)){
			this.obtenirCasePersonnage(perso).enleverPersonnage();
			this.carte[position.obtenirX()][position.obtenirY()].ajouterPersonnage(perso, numeroJoueur);
			return true;
		}
		return false;
	}
	
	private boolean nombreDeDeplacementEstSuffisant(Position position, Personnage perso) {
		int calculDeplacement = 0;
		calculDeplacement = Math.abs(position.obtenirX() - 
				this.obtenirPositionPersonnage(perso).obtenirX());
		calculDeplacement += Math.abs(position.obtenirY() - 
				this.obtenirPositionPersonnage(perso).obtenirY());
		if(perso.obtenirNombreDeplacement() >= calculDeplacement)
			return true;
		return false;
	}

	public void placerPersonnage(Position position, Personnage perso){
			this.carte[position.obtenirX()][position.obtenirY()].modifierEstOccupe(perso);
	}

	/**
	 * Retournes la case sur laquelle est le personnage
	 * @param perso Personnage pour lequelle on veut obtenir la case
	 * @return la case sur laquelle il se trouve (null si personnage non trouvé)
	 */
	
	public Position obtenirPositionPersonnage(Personnage perso){
		for(int i = 0; i < obtenirTailleEnX();i++){
			for(int j = 0; j < obtenirTailleEnY();j++){
				if(perso == this.carte[i][j].estOccupe())
					return new Position(i,j); 
			}
		}
		return null;
	}
	
	public Case obtenirCasePersonnage(Personnage perso){
		for(int i = 0; i < obtenirTailleEnX();i++){
			for(int j = 0; j < obtenirTailleEnY();j++){
				if(perso == this.carte[i][j].estOccupe())
					return this.carte[i][j]; 
			}
		}
		return null;
	}
	
	/**
	 * Renvoi true si le deplacement est possible
	 * et false si impossible
	 * @return
	 */
	public boolean deplacementEstPossible(Position position){
		return (!(!(this.carte[position.obtenirX()][position.obtenirY()].estOccupe() instanceof PersonnageVide) || 
				this.carte[position.obtenirX()][position.obtenirY()].estPleine()));
	}
	
	
	public void afficherCarte(){
		for(int i=0; i < TAILLE_X_DEFAUT; i++){
			for(int j=0; j < TAILLE_Y_DEFAUT; j++){
				if(this.carte[i][j].estOccupe() instanceof Personnage)
					System.out.print("▲");
				else
					System.out.print("◘");
			}
			System.out.println();
		}
	}
	/**
	 * Actualise l'affichage de la carte
	 */
	public Case[][] obtenirCarte(){
		return this.carte;
	}
	
	public int obtenirTailleEnX(){
		return this.carte.length;
	}
	
	public int obtenirTailleEnY(){
		if(this.carte.length==0) return 0;
		else return this.carte[0].length;
	}
	
	public void modifierCarte(Case[][] carte) {
		this.carte = carte;
	}
}
