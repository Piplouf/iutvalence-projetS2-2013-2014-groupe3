package fr.projetS2_2013_2014_groupe3.menu.carte;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Perso;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.PersonnageVide;
import fr.projetS2_2013_2014_groupe3.jeu.Position;
import fr.projetS2_2013_2014_groupe3.jeuEnCours.InterfacePartie;
import fr.projetS2_2013_2014_groupe3.menu.personnage.PersonnageMenu;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class BoutonCarteEnJeu extends JButton {

	private Partie partie;

	private Case uneCase;

	private Position position;

	private InterfacePartie ecran;

	private ImageIcon image;

	private int numeroJoueur;

	public BoutonCarteEnJeu(final Partie partieEnCours, Case laCase,
			final InterfacePartie ecran, Position posi) {

		super();
		this.ecran = ecran;
		this.uneCase = laCase;
		this.partie = partieEnCours;
		this.position = posi;
		this.numeroJoueur = this.uneCase.obtenirNumeroJoueur();

		this.setPreferredSize(new Dimension(100, 100));
		if (!(this.uneCase.estOccupe() instanceof PersonnageVide)) {
			this.image = new PersonnageMenu()
					.rechercheImagePersonnage((Personnage) this.uneCase
							.estOccupe());
			if (this.numeroJoueur == 1)
				this.setBorder(BorderFactory.createLineBorder(Color.RED));
			if (this.numeroJoueur == 2)
				this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		} else
			this.image = new ImageIcon("img/case.png");
		if (this.uneCase.estPleine()) {
			this.setEnabled(false);
			this.setBackground(Color.BLACK);
			this.setBorderPainted(false);
		}
		this.setIcon(this.image);

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// On vérifie que la case sur laquelle appuie le joueur est bien
				// un personnage et si c'est un personnage que c'est bien
				// l'un des siens
				if (uneCase.estOccupe() instanceof Personnage
						&& uneCase.obtenirNumeroJoueur() == partieEnCours
								.obtenirNumJoueur()) {
					ecran.obtenirPersoSel().setText(
							((Personnage) uneCase.estOccupe()).obtenirNom());
					ecran.modifierPersonnageCourant((Personnage) uneCase
							.estOccupe());
					ecran.obtenirBoutonAttaquer().setEnabled(true);
					ecran.obtenirBoutonDeplacer().setEnabled(true);
				} else {
					ecran.obtenirBoutonAttaquer().setEnabled(false);
					ecran.obtenirBoutonDeplacer().setEnabled(false);
				}

				if (ecran.obtenirACliquerSurBoutonDeplacer()){
					boolean deplacementAReussi = partie.obtenirCarte().deplacerPersonnage(obtenirPosition(),
							ecran.obtenirPersonnageCourant(), partie.obtenirNumJoueur());
					if(deplacementAReussi){
						partie.modifierNumeroJoueur();
						ecran.obtenirFenetre().modifierPanneau(new InterfacePartie(ecran.obtenirFenetre(),partie));
					}
					else
						ecran.modifierACliquerSurBoutonDeplacer(false);
				}
			}
		});

	}

	public Perso obtenirPersoDansCase() {
		return this.uneCase.estOccupe();
	}

	public Position obtenirPosition() {
		return this.position;
	}

}