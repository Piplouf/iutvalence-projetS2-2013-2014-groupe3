package fr.projetS2_2013_2014_groupe3.menu.carte;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeuEnCours.InterfacePartie;

/** Bouton utiliser par le joueur lorsque ceux-ci ont choisi une carte */
@SuppressWarnings("serial")
public class BoutonValidationCarte extends JButton implements ActionListener{

	private MenuCarte ecranPerso;

	public BoutonValidationCarte(MenuCarte ecran) {

		this.ecranPerso = ecran;
		this.setText("Valider");
		this.setEnabled(false);
		this.setPreferredSize(new Dimension(200, 50));
		this.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.ecranPerso.obtenirPartie().ajouterCarte(ecranPerso.obtenirBoutonCarte().obtenirCarteMenuCourante().obtenirCarte());
		this.ecranPerso.obtenirFenetre().modifierPanneau(new InterfacePartie(ecranPerso.obtenirFenetre(), ecranPerso.obtenirPartie()));
		
	}

}
