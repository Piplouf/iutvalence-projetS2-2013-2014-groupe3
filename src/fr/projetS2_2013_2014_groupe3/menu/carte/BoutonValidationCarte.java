package fr.projetS2_2013_2014_groupe3.menu.carte;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeuEnCours.InterfacePartie;
import fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes.CarteDeBase;

public class BoutonValidationCarte extends JButton {

	private MenuCarte ecranPerso;

	public BoutonValidationCarte(MenuCarte ecran) {

		this.ecranPerso = ecran;
		this.setText("Valider");
		this.setEnabled(true);
		this.setPreferredSize(new Dimension(200, 50));
		this.addActionListener(new ActionListener() {

			/**
			 * Se déclenche lorsque l'on appuie sur le bouton valider lors de la
			 * séléction des personnages attribut l'equipe choisie au joueur
			 */
			public void actionPerformed(ActionEvent arg0) {
				//ecranPerso.obtenirPartie().ajouterCarte(ecranPerso.obtenirBoutonCarte().obtenirCarteMenu().obtenirCarte());
				ecranPerso.obtenirPartie().ajouterCarte(new CarteDeBase(ecranPerso.obtenirPartie()));
				ecranPerso.obtenirFenetre().modifierPanneau(new InterfacePartie(ecranPerso.obtenirFenetre(), ecranPerso.obtenirPartie()));
			}

		});

	}

}
