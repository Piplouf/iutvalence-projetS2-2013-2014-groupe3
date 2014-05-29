package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.menu.carte.ModelisationCarte;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class InterfacePartie extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3975533453012006418L;

	private Fenetre fen;

	private Partie partie;
	private Personnage personnage;

	private JLabel nomJoueur;
	private JLabel persoSelection;
	private JLabel etatPersoJoueur1;
	private JLabel etatPersoJoueur2;

	private JPanel menuJoueur;

	private BoutonAttaquer boutonAttaquer;
	private BoutonDeplacer boutonDeplacer;

	private ModelisationCarte carteModeliser;

	private boolean ACliquerSurBoutonDeplacer;
	private boolean estEnModeAttaque;

	public InterfacePartie(Fenetre fen, Partie partie) {
		super();
		this.fen = fen;
		this.partie = partie;
		this.personnage = null;
		this.ACliquerSurBoutonDeplacer = false;
		this.estEnModeAttaque = false;
		this.carteModeliser = new ModelisationCarte(this.fen, this.partie, this);

		InitGUI();
	}

	private void InitGUI() {

		this.etatPersoJoueur1 = new JLabel();
		this.etatPersoJoueur2 = new JLabel();
		this.nomJoueur = new JLabel();
		this.persoSelection = new JLabel();
		this.boutonAttaquer = new BoutonAttaquer(this.fen, this.partie, this);
		this.boutonDeplacer = new BoutonDeplacer(this.fen, this.partie, this);

		JPanel conteneurFinal = new JPanel();
		JPanel grille = new JPanel();
		this.menuJoueur = new JPanel();
		JPanel nomJoueur = new JPanel();
		JPanel persoSel = new JPanel();
		JPanel sud = new JPanel();
		JPanel ouest = new JPanel();
		JPanel est = new JPanel();

		this.etatPersoJoueur1.setPreferredSize(new Dimension(560, 800));
		this.etatPersoJoueur1.setFont(new Font("Arial", Font.BOLD, 14));
		this.etatPersoJoueur1.setHorizontalAlignment(JLabel.CENTER);

		this.etatPersoJoueur2.setPreferredSize(new Dimension(560, 800));
		this.etatPersoJoueur2.setFont(new Font("Arial", Font.BOLD, 14));
		this.etatPersoJoueur2.setHorizontalAlignment(JLabel.CENTER);

		this.afficherEtatPersoJoueurs();

		ouest.add(this.etatPersoJoueur1);
		est.add(this.etatPersoJoueur2);

		conteneurFinal.setLayout(new BorderLayout());
		sud.setLayout(new BoxLayout(sud, BoxLayout.PAGE_AXIS));

		GridLayout layoutGrille = new GridLayout(2, 2);
		layoutGrille.setHgap(1);
		layoutGrille.setVgap(1);

		this.menuJoueur.setLayout(layoutGrille);

		grille.add(this.carteModeliser);

		this.nomJoueur.setText("Joueur "
				+ Integer.toString(this.partie.obtenirNumJoueur()));
		if (this.partie.obtenirNumJoueur() == 1) {
			this.nomJoueur.setFont(new Font("Arial", Font.BOLD, 16));
			this.nomJoueur.setForeground(Color.RED);
		} else {
			this.nomJoueur.setFont(new Font("Arial", Font.BOLD, 16));
			this.nomJoueur.setForeground(Color.BLUE);
		}

		nomJoueur.add(this.nomJoueur);

		this.persoSelection.setPreferredSize(new Dimension(400, 20));
		this.persoSelection.setFont(new Font("Arial", Font.BOLD, 16));
		this.persoSelection.setHorizontalAlignment(JLabel.CENTER);
		persoSel.add(this.persoSelection);

		JPanel boutonAttaque = new JPanel();
		JPanel boutonDepl = new JPanel();
		JPanel boutonSac = new JPanel();
		JPanel boutonPass = new JPanel();

		boutonAttaque.add(this.boutonAttaquer);
		boutonDepl.add(this.boutonDeplacer);
		boutonSac.add(new BoutonSac(this.fen, this.partie, this));
		boutonPass.add(new BoutonPasserTour(this.fen, this.partie, this));

		this.menuJoueur.add(boutonAttaque);
		this.menuJoueur.add(boutonDepl);
		this.menuJoueur.add(boutonSac);
		this.menuJoueur.add(boutonPass);

		JPanel menuJoueur2 = new JPanel();
		menuJoueur2.add(menuJoueur);

		sud.add(persoSel);
		sud.add(menuJoueur2);

		conteneurFinal.add(nomJoueur, BorderLayout.NORTH);
		conteneurFinal.add(grille, BorderLayout.CENTER);
		conteneurFinal.add(sud, BorderLayout.SOUTH);
		conteneurFinal.add(ouest, BorderLayout.WEST);
		conteneurFinal.add(est, BorderLayout.EAST);

		this.add(conteneurFinal);
		this.setVisible(true);

	}

	public void refreshTexte(int numeroJoueur) {
		this.nomJoueur.setText("Joueur " + Integer.toString(numeroJoueur));
		if (this.partie.obtenirNumJoueur() == 1) {
			this.nomJoueur.setFont(new Font("Arial", Font.BOLD, 16));
			this.nomJoueur.setForeground(Color.RED);
		} else {
			this.nomJoueur.setFont(new Font("Arial", Font.BOLD, 16));
			this.nomJoueur.setForeground(Color.BLUE);
		}
	}

	public void afficherZoneAffecterParCompetences(ArrayList<Case> cases) {

		for (Case laCase : cases) {
			this.carteModeliser.obtenirBoutonsAPosition(laCase.obtenirPosition()).modifierEnZoneQuiVaEtreAttaquer(true);
		}
	}
	
	public void retirerZoneAffecterParCompetences(ArrayList<Case> cases) {

		for (Case laCase : cases) {
			this.carteModeliser.obtenirBoutonsAPosition(laCase.obtenirPosition()).modifierEnZoneQuiVaEtreAttaquer(false);
		}
	}

	public void afficherEtatPersoJoueurs() {
		this.etatPersoJoueur1.setText("<html><center>Joueur 1</center><br><br>"
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(0).toString()
				+ "<br><br>"
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(1).toString()
				+ "<br><br>"
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(2).toString()
				+ "<br><br>"
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(3).toString()
				+ "<br><br>");

		this.etatPersoJoueur2.setText("<html><center>Joueur 2</center><br><br>"
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(0).toString()
				+ "<br><br>"
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(1).toString()
				+ "<br><br>"
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(2).toString()
				+ "<br><br>"
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(3).toString()
				+ "<br><br>");
	}

	public void modifierPersonnageCourant(Personnage perso) {
		this.personnage = perso;
	}

	public void modifierMenuJoueurEnMenuAttaque(Personnage perso) {
		this.menuJoueur.removeAll();
		this.menuJoueur
				.add(new MenuAttaque(this.fen, this.partie, this, perso));
		this.revalidate();
	}

	public void modifierMenuAttaqueEnMenuJoueur() {

		this.menuJoueur.removeAll();
		this.menuJoueur.add(new MenuJoueur(fen, partie, this));
		this.revalidate();
	}

	public void modifierACliquerSurBoutonDeplacer(boolean modif) {
		this.ACliquerSurBoutonDeplacer = modif;
	}

	public void estEnModeAttaque(boolean modif) {
		this.estEnModeAttaque = modif;
	}

	public boolean obtenirEstEnModeAttaque() {
		return this.estEnModeAttaque;
	}

	public JPanel obtenirMenuJoueur() {
		return this.menuJoueur;
	}

	/**
	 * Permet d'obtenir le menu d'attaque seulement lorsque le jeu est en mode
	 * attaque
	 */
	public MenuAttaque obtenirMenuAttaque() {
		return (MenuAttaque) this.menuJoueur.getComponent(0);
	}

	public boolean obtenirACliquerSurBoutonDeplacer() {
		return this.ACliquerSurBoutonDeplacer;
	}

	public JLabel obtenirPersoSel() {
		return this.persoSelection;
	}

	public BoutonAttaquer obtenirBoutonAttaquer() {
		return this.boutonAttaquer;
	}

	public Personnage obtenirPersonnageCourant() {
		return this.personnage;
	}

	public BoutonDeplacer obtenirBoutonDeplacer() {
		return this.boutonDeplacer;
	}

	public ModelisationCarte obtenirCarteModeliser() {
		return this.carteModeliser;
	}

	public void modifierCarteModeliser(ModelisationCarte nouvelleCarte) {
		this.carteModeliser = nouvelleCarte;
	}

	public Fenetre obtenirFenetre() {
		return this.fen;
	}

	public void refresh() {
		this.refreshTexte(this.partie.obtenirNumJoueur());
		this.afficherEtatPersoJoueurs();
		this.carteModeliser.refresh();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (estEnModeAttaque)
			this.menuJoueur = new MenuJoueur(fen, partie, this);
	}

}
