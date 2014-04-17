
public class Carte {

	private static final int TAILLE_Y_DEFAUT = 10;
	private static final int TAILLE_X_DEFAUT = 10;
	private Case[][] carte;
	
	public Carte(Case[][] carteVoulue){
		this.carte = new Case[TAILLE_X_DEFAUT][TAILLE_Y_DEFAUT];
		this.carte = carteVoulue;
	}
	
	/**
	 * Permet de deplacer le personnage
	 */
	public void deplacerPersonnage(Position position, Personnage perso){
		if(deplacementEstPossible(position)){
			this.obtenirCasePersonnage(perso).modifierEstOccupe(null);
			this.carte[position.obtenirX()][position.obtenirY()].modifierEstOccupe(perso);
		}
	}
	
	/**
	 * Retournes la case sur laquelle est le personnage
	 * @param perso Personnage pour lequelle on veut obtenir la case
	 * @return la case sur laquelle il se trouve (null si personnage non trouvé)
	 */
	private Case obtenirCasePersonnage(Personnage perso){
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
		return (!(this.carte[position.obtenirX()][position.obtenirY()].estOccupe()!= null || 
				this.carte[position.obtenirX()][position.obtenirY()].estPleine()));
	}
	
	/**
	 * Actualise l'affichage de la carte
	 */
	public void actualiserCarte(){
		
	}
	
	public int obtenirTailleEnX(){
		return this.carte.length;
	}
	
	public int obtenirTailleEnY(){
		if(this.carte.length==0) return 0;
		else return this.carte[0].length;
	}
}
