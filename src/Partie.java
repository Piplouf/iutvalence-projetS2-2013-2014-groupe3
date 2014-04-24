
public class Partie {
	
	private Joueur[] joueur;
	
	private Carte carte;
	
	public Partie(){
		this.joueur = new Joueur[2];
		this.joueur[0] = new Joueur();
		this.joueur[1] = new Joueur();
		this.carte = new Carte();
	}
	
	public void ajouterCarte(Carte carte){
		this.carte = carte;
	}
	
	public void ajouterPersonnage(Personnage perso){
		this.joueur[0].ajouterJoueur(perso);
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
		
		this.carte.deplacerPersonnage(new Position(1,4), this.joueur[0].obtenirPersonnage(0));
		
		this.carte.afficherCarte();
	}
	
}
