package fr.projetS2_2013_2014_groupe3.jeu;
import javax.swing.SwingUtilities;

import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

/** Lanceur de l'application */
public class Jeu {

	public static void main(String[] args) {
		
		Partie partie = new Partie();
		Fenetre fenetre = new Fenetre(partie);
		SwingUtilities.invokeLater(fenetre);

	}
}
