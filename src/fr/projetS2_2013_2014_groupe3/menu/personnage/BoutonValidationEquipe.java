package fr.projetS2_2013_2014_groupe3.menu.personnage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeuEnCours.InterfacePartie;
import fr.projetS2_2013_2014_groupe3.menu.carte.ModelisationCarte;
import fr.projetS2_2013_2014_groupe3.menu.carte.MenuCarte;

public class BoutonValidationEquipe extends JButton {

	private MenuPersonnage ecranPerso;

	public BoutonValidationEquipe(MenuPersonnage ecran, final int num) {

		this.ecranPerso = ecran;
		this.setText("Valider");
		this.setEnabled(false);
		this.setPreferredSize(new Dimension(200, 50));
		this.addActionListener(new ActionListener() {

			/**
			 * Se déclenche lorsque l'on appuie sur le bouton valider lors de la
			 * séléction des personnages attribut l'equipe choisie au joueur
			 */
			public void actionPerformed(ActionEvent arg0) {

				ecranPerso
						.obtenirPartie()
						.obtenirJoueur(num)
						.ajouterEquipe(
								ecranPerso.obtenirEquipeDuJoueur()
										.obtenirPersonnageEquipe());
				if (num == 0)
					ecranPerso.obtenirFenetre().modifierPanneau(
							new MenuPersonnage(ecranPerso.obtenirFenetre(),
									ecranPerso.obtenirPartie(), 1));
				else
					 ecranPerso.obtenirFenetre().modifierPanneau( new
					 MenuCarte(ecranPerso.obtenirFenetre(),
					 ecranPerso.obtenirPartie()));
			}

		});
	}

}
