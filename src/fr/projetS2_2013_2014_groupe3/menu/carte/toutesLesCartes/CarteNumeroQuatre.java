package fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes;

import fr.projetS2_2013_2014_groupe3.exceptions.NumeroJoueurErronne;
import fr.projetS2_2013_2014_groupe3.exceptions.PositionErronne;
import fr.projetS2_2013_2014_groupe3.jeu.Carte;
import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class CarteNumeroQuatre extends Carte {

	public CarteNumeroQuatre(Partie partie) throws PositionErronne, NumeroJoueurErronne {
	
		this.modifierCarte(new Case[15][15]);
		
		Personnage[] equipe1 = new Personnage[4];
		Personnage[] equipe2 = new Personnage[4];

		equipe1 = partie.obtenirJoueur(0).obtenirPersonnageDUneEquipe();
		equipe2 = partie.obtenirJoueur(1).obtenirPersonnageDUneEquipe();
		
		int i = 0;
		int j = 0;
		
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				if (x == 2 && y == 1 || x == 2 && y == 4 || x == 1 && y == 8
						|| x == 2 && y == 14)
					this.obtenirCarte()[x][y] = new Case(equipe1[i++], 1, new Position(x,y));
				else if (x == 13 && y == 3 || x == 13 && y == 7 || x == 13
						&& y == 10 || x == 13 && y == 13)
					this.obtenirCarte()[x][y] = new Case(equipe2[j++], 2, new Position(x,y));
				else if (x == 6 && y == 3 || x == 6 && y == 4 || x == 6
						&&  y == 5
						|| x == 7 && y == 3 || x == 7 && y == 4 || x == 7
						&& y == 5 || x == 6 && y == 11 || x == 6 && y == 12 || x == 6
								&&  y == 13
								|| x == 7 && y == 11 || x == 7 && y == 12 || x == 7
								&& y == 13 || x == 9 && y == 8 || x == 9 && y == 9
						|| x == 9 && y == 10 || x == 10 && y == 8
						|| x == 10 && y == 9 || x == 10 && y == 10)
					this.obtenirCarte()[x][y] = new Case(true, new Position(x,y));
				else
					this.obtenirCarte()[x][y] = new Case(new Position(x,y));
			}
		}
	}
}
