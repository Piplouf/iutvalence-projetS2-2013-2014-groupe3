package fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes;

import fr.projetS2_2013_2014_groupe3.exceptions.NumeroJoueurErronne;
import fr.projetS2_2013_2014_groupe3.exceptions.PositionErronne;
import fr.projetS2_2013_2014_groupe3.jeu.Carte;
import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class CarteNumeroCinq extends Carte {
	
	private static int TAILLE_X_DEFAUT = 15;
	private static int TAILLE_Y_DEFAUT = 15;

	public CarteNumeroCinq(Partie partie) throws PositionErronne, NumeroJoueurErronne {
	
		this.modifierCarte(new Case[TAILLE_X_DEFAUT][TAILLE_Y_DEFAUT]);
		
		Personnage[] equipe1 = new Personnage[4];
		Personnage[] equipe2 = new Personnage[4];

		equipe1 = partie.obtenirJoueur(0).obtenirPersonnageDUneEquipe();
		equipe2 = partie.obtenirJoueur(1).obtenirPersonnageDUneEquipe();
		
		int i = 0;
		int j = 0;
		
		for (int x = 0; x < TAILLE_X_DEFAUT; x++) {
			for (int y = 0; y < TAILLE_Y_DEFAUT; y++) {
				if (x == 2 && y == 1 || x == 2 && y == 4 || x == 1 && y == 8
						|| x == 2 && y == 14)
					this.obtenirCarte()[x][y] = new Case(equipe1[i++], 1, new Position(x,y));
				else if (x == 13 && y == 3 || x == 13 && y == 7 || x == 13
						&& y == 10 || x == 13 && y == 13)
					this.obtenirCarte()[x][y] = new Case(equipe2[j++], 2, new Position(x,y));
				else
					this.obtenirCarte()[x][y] = new Case(new Position(x,y));
			}
		}
	}
}
