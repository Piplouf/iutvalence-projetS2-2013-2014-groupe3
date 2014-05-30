package fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes;

import fr.projetS2_2013_2014_groupe3.exceptions.NumeroJoueurErronne;
import fr.projetS2_2013_2014_groupe3.exceptions.PositionErronne;
import fr.projetS2_2013_2014_groupe3.jeu.Carte;
import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class CarteNumeroUn extends Carte {

	public CarteNumeroUn(Partie partie) throws PositionErronne, NumeroJoueurErronne {
	
		this.modifierCarte(new Case[TAILLE_X_DEFAUT][TAILLE_Y_DEFAUT]);
		
		Personnage[] equipe1 = new Personnage[4];
		Personnage[] equipe2 = new Personnage[4];

		equipe1 = partie.obtenirJoueur(0).obtenirPersonnageDUneEquipe();
		equipe2 = partie.obtenirJoueur(1).obtenirPersonnageDUneEquipe();
		
		int i = 0;
		int j = 0;
		
		for (int x = 0; x < TAILLE_X_DEFAUT; x++) {
			for (int y = 0; y < TAILLE_Y_DEFAUT; y++) {
				if (x == 0 && y == 1 || x == 1 && y == 3 || x == 0 && y == 5
						|| x == 1 && y == 7)
					this.obtenirCarte()[x][y] = new Case(equipe1[i++], 1, new Position(x,y));
				else if (x == 7 && y == 0 || x == 6 && y == 2 || x == 7
						&& y == 4 || x == 6 && y == 6)
					this.obtenirCarte()[x][y] = new Case(equipe2[j++], 2, new Position(x,y));
				else if (x == 3 && y == 0 || x == 4 && y == 0 || x == 3
						&&  y == 2
						|| x == 4 && y == 2 || x == 3 && y == 5 || x == 4
						&& y == 5 || x == 3 && y == 7 || x == 4 && y == 7)
					this.obtenirCarte()[x][y] = new Case(true, new Position(x,y));
				else
					this.obtenirCarte()[x][y] = new Case(new Position(x,y));
			}
		}
	}
}
