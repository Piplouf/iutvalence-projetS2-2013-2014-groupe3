package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import fr.projetS2_2013_2014_groupe3.competences.CompetenceVide;
import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Perso;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.PersonnageVide;
import fr.projetS2_2013_2014_groupe3.jeu.Position;
import fr.projetS2_2013_2014_groupe3.menu.personnage.PersonnageMenu;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class BoutonCarteEnJeu extends JButton implements ActionListener,
		MouseListener {

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

		InitGUI();

		this.addActionListener(this);
		this.addMouseListener(this);

	}

	public void InitGUI() {
		
		this.setContentAreaFilled(false);
		this.setPreferredSize(new Dimension((int) 800
				/ this.partie.obtenirCarte().obtenirTailleEnY(), (int) 800
				/ this.partie.obtenirCarte().obtenirTailleEnX()));

		if (!(this.uneCase.estOccupe() instanceof PersonnageVide)) {
			this.image = new PersonnageMenu().rechercheImagePersonnage(
					(Personnage) this.uneCase.estOccupe(), this.partie);
			if (this.numeroJoueur == 1)
				this.setBorder(BorderFactory.createLineBorder(Color.RED));
			if (this.numeroJoueur == 2)
				this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		} else
			this.image = new ImageIcon("img/case.png");
			//this.setText(this.position.toString());
		if (this.uneCase.estPleine()) {
			this.setEnabled(false);
			this.setBackground(Color.BLACK);
			this.setBorderPainted(false);
		}
		this.setIcon(this.image);
	}

	public void effectuerDeplacement() {
		boolean deplacementAReussi = this.partie.obtenirCarte()
				.deplacerPersonnage(obtenirPosition(),
						this.ecran.obtenirPersonnageCourant(),
						this.partie.obtenirNumJoueur());
		if (deplacementAReussi) {
			this.partie.modifierNumeroJoueur();
			ecran.refresh();
		} else
			this.ecran.modifierACliquerSurBoutonDeplacer(false);
	}

	public void modifierEnZoneQuiVaEtreAttaquer(boolean test) {
		if(test)
			this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		else
			if(this.uneCase.estOccupe() instanceof PersonnageVide)
				this.setBorder(UIManager.getBorder("Button.border"));
			else{
				if(this.numeroJoueur == 1)
					this.setBorder(BorderFactory.createLineBorder(Color.RED));
				else
					this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
	}

	public Perso obtenirPersoDansCase() {
		return this.uneCase.estOccupe();
	}

	public Position obtenirPosition() {
		return this.position;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (uneCase.estOccupe() instanceof Personnage
				&& uneCase.obtenirNumeroJoueur() == this.partie
						.obtenirNumJoueur()) {
			ecran.obtenirPersoSel().setText(
					((Personnage) uneCase.estOccupe()).obtenirNom());
			ecran.modifierPersonnageCourant((Personnage) uneCase.estOccupe());
			ecran.obtenirBoutonAttaquer().setEnabled(true);
			ecran.obtenirBoutonDeplacer().setEnabled(true);
		} else {
			ecran.obtenirPersoSel().setText("");
			ecran.obtenirBoutonAttaquer().setEnabled(false);
			ecran.obtenirBoutonDeplacer().setEnabled(false);
		}

		if (ecran.obtenirEstEnModeAttaque()) {
			if (!(ecran.obtenirMenuAttaque()
					.obtenirCompetenceVoulantEtreLancer() instanceof CompetenceVide)){
				ecran.obtenirMenuAttaque()
						.obtenirCompetenceVoulantEtreLancer()
						.utiliserCompetence(
								this.ecran.obtenirMenuAttaque().obtenirPerso(),
								this.position);
			this.ecran.modifierMenuAttaqueEnMenuJoueur();
			this.ecran.estEnModeAttaque(false);
			this.ecran.refresh();
			}

		}

		if (ecran.obtenirACliquerSurBoutonDeplacer()) {
			effectuerDeplacement();
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

		if (ecran.obtenirEstEnModeAttaque()) {
			if (!(ecran.obtenirMenuAttaque()
					.obtenirCompetenceVoulantEtreLancer() instanceof CompetenceVide))
				this.ecran.afficherZoneAffecterParCompetences(ecran.obtenirMenuAttaque()
						.obtenirCompetenceVoulantEtreLancer()
						.retournerZoneAffecterParAttaque(
								this.ecran.obtenirMenuAttaque().obtenirPerso(),
								this.position));
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		if (ecran.obtenirEstEnModeAttaque()) {
			if (!(ecran.obtenirMenuAttaque()
					.obtenirCompetenceVoulantEtreLancer() instanceof CompetenceVide))
				this.ecran.retirerZoneAffecterParCompetences(ecran.obtenirMenuAttaque()
						.obtenirCompetenceVoulantEtreLancer()
						.retournerZoneAffecterParAttaque(
								this.ecran.obtenirMenuAttaque().obtenirPerso(),
								this.position));
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
