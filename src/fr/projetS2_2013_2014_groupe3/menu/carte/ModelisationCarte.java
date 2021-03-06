package fr.projetS2_2013_2014_groupe3.menu.carte;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Position;
import fr.projetS2_2013_2014_groupe3.jeuEnCours.BoutonCarteEnJeu;
import fr.projetS2_2013_2014_groupe3.jeuEnCours.InterfacePartie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

/** Modélisateur de carte sur une ihm*/
@SuppressWarnings("serial")
public class ModelisationCarte extends JPanel {

	private Partie partie;

	private Fenetre fen;

	private InterfacePartie ecran;
	
	private BoutonCarteEnJeu[][] boutons;
	
	public ModelisationCarte(Fenetre fenetre, Partie partieEnCours, InterfacePartie interfacePartie) {

		super();
		this.fen = fenetre;
		this.partie = partieEnCours;
		this.ecran = interfacePartie;
		this.boutons = new BoutonCarteEnJeu[this.partie.obtenirCarte().obtenirTailleEnX()][this.partie.obtenirCarte().obtenirTailleEnY()];
		refreshGUI();
	}
	
	public void refresh(){
		refreshGUI();
	}
	
	/** Reinitialise l'affichage de la carte*/
	private void refreshGUI() {
		this.removeAll();
		JPanel conteneurFinal = new JPanel();
		JPanel grille = new JPanel();

		grille.setLayout(new GridLayout(this.partie.obtenirCarte().obtenirTailleEnX(), this.partie.obtenirCarte().obtenirTailleEnY()));

		for (int x = 0; x < this.partie.obtenirCarte().obtenirTailleEnX(); x++) {
			for (int y = 0; y < this.partie.obtenirCarte().obtenirTailleEnY(); y++) {
				grille.add(new JPanel().add(this.boutons[x][y] = new BoutonCarteEnJeu(this.partie,
						this.partie.obtenirCarte().obtenirCarte()[x][y], this.ecran, new Position(x,y))));
			}
		}

		conteneurFinal.add(grille);
		this.add(conteneurFinal);

		this.setVisible(true);
		JFrame.setDefaultLookAndFeelDecorated(false);
		this.fen.setExtendedState(Frame.MAXIMIZED_BOTH);
		
	}
	
	public BoutonCarteEnJeu[][] obtenirBoutons(){
		return this.boutons;
	}
	
	/** Permet d'obtenir le bouton en fonction de la position donner*/
	public BoutonCarteEnJeu obtenirBoutonsAPosition(Position position){
		return this.boutons[position.obtenirX()][position.obtenirY()];
	}

}
