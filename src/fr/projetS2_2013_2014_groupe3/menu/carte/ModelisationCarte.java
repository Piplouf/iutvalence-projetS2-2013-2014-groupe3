package fr.projetS2_2013_2014_groupe3.menu.carte;

import java.awt.GridLayout;

import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;
import fr.projetS2_2013_2014_groupe3.jeuEnCours.InterfacePartie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class ModelisationCarte extends JPanel {

	private Partie partie;

	private Fenetre fen;

	private InterfacePartie ecran;
	
	public ModelisationCarte(Fenetre fenetre, Partie partieEnCours, InterfacePartie interfacePartie) {

		super();
		this.fen = fenetre;
		this.partie = partieEnCours;
		this.ecran = interfacePartie;

		JPanel conteneurFinal = new JPanel();
		JPanel grille = new JPanel();

		grille.setLayout(new GridLayout(8, 8));

		for (int x = 0; x < this.partie.obtenirCarte().obtenirTailleEnX(); x++) {
			for (int y = 0; y < this.partie.obtenirCarte().obtenirTailleEnY(); y++) {
				grille.add(new JPanel().add(new BoutonCarteEnJeu(this.partie,
						this.partie.obtenirCarte().obtenirCarte()[x][y], this.ecran, new Position(x,y) )));
			}
		}

		conteneurFinal.add(grille);
		this.add(conteneurFinal);

		this.setVisible(true);
		this.fen.setDefaultLookAndFeelDecorated(false);
		this.fen.setExtendedState(this.fen.MAXIMIZED_BOTH);
	}

}