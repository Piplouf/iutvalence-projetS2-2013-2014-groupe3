package fr.projetS2_2013_2014_groupe3.jeu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;





public class Jeu {

	public static void main(String[] args) {
		
		Partie partie = new Partie();
		Fenetre fenetre = new Fenetre(partie);

	}
}
