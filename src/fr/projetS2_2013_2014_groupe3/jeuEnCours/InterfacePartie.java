package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.menu.carte.ModelisationCarte;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class InterfacePartie extends JPanel {

	private Fenetre fen;

	private Partie partie;
	private Personnage personnage;

	private JLabel nomJoueur;
	private JLabel persoSelection;
	private JLabel etatPersoJoueur1;
	private JLabel etatPersoJoueur2;

	private BoutonAttaquer boutonAttaquer;
	private BoutonDeplacer boutonDeplacer;

	private ModelisationCarte carteModeliser;

	private boolean ACliquerSurBoutonDeplacer;

	public InterfacePartie(Fenetre fen, Partie partie) {
		super();
		this.fen = fen;
		this.partie = partie;
		this.personnage = null;
		this.ACliquerSurBoutonDeplacer = false;
		this.carteModeliser = new ModelisationCarte(this.fen, this.partie, this);

		this.nomJoueur = new JLabel();
		this.etatPersoJoueur1 = new JLabel();
		this.etatPersoJoueur2 = new JLabel();
		this.persoSelection = new JLabel();
		this.boutonAttaquer = new BoutonAttaquer(this.fen, this.partie, this);
		this.boutonDeplacer = new BoutonDeplacer(this.fen, this.partie, this);

		JPanel conteneurFinal = new JPanel();
		JPanel grille = new JPanel();
		JPanel menuJoueur = new JPanel();
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

		menuJoueur.setLayout(layoutGrille);

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
		boutonSac.add(new BoutonSac(this.fen, this.partie));
		boutonPass.add(new BoutonPasserTour(this.fen,this.partie));
		

		menuJoueur.add(boutonAttaque);
		menuJoueur.add(boutonDepl);
		menuJoueur.add(boutonSac);
		menuJoueur.add(boutonPass);
		
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
		// TODO Auto-generated constructor stub
	}

	public void afficherEtatPersoJoueurs() {
		this.etatPersoJoueur1.setText("<html><center>Joueur 1</center><br><br>"
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(0)
						.obtenirNom()
				+ "<br>Vie : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(0)
						.obtenirVie()
				+ " / "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(0)
						.obtenirVie()
				+ "<br>Capacité de déplacement : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(0)
						.obtenirNombreDeplacement()
				+ "<br>Puissance : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(0)
						.obtenirPuissance()
				+ "<br><br>"

				+ this.partie.obtenirJoueur(0).obtenirPersonnage(1)
						.obtenirNom()
				+ "<br>Vie : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(1)
						.obtenirVie()
				+ " / "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(1)
						.obtenirVie()
				+ "<br>Capacité de déplacement : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(1)
						.obtenirNombreDeplacement()
				+ "<br>Puissance : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(1)
						.obtenirPuissance()
				+ "<br><br>"

				+ this.partie.obtenirJoueur(0).obtenirPersonnage(2)
						.obtenirNom()
				+ "<br>Vie : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(2)
						.obtenirVie()
				+ " / "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(2)
						.obtenirVie()
				+ "<br>Capacité de déplacement : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(2)
						.obtenirNombreDeplacement()
				+ "<br>Puissance : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(2)
						.obtenirPuissance()
				+ "<br><br>"
				
				
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(3)
						.obtenirNom()
				+ "<br>Vie : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(3)
						.obtenirVie()
				+ " / "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(3)
						.obtenirVie()
				+ "<br>Capacité de déplacement : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(3)
						.obtenirNombreDeplacement()
				+ "<br>Puissance : "
				+ this.partie.obtenirJoueur(0).obtenirPersonnage(3)
						.obtenirPuissance() + "<br><br>");
		
		this.etatPersoJoueur2.setText("<html><center>Joueur 2</center><br><br>"
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(0)
						.obtenirNom()
				+ "<br>Vie : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(0)
						.obtenirVie()
				+ " / "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(0)
						.obtenirVie()
				+ "<br>Capacité de déplacement : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(0)
						.obtenirNombreDeplacement()
				+ "<br>Puissance : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(0)
						.obtenirPuissance()
				+ "<br><br>"

				+ this.partie.obtenirJoueur(1).obtenirPersonnage(1)
						.obtenirNom()
				+ "<br>Vie : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(1)
						.obtenirVie()
				+ " / "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(1)
						.obtenirVie()
				+ "<br>Capacité de déplacement : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(1)
						.obtenirNombreDeplacement()
				+ "<br>Puissance : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(1)
						.obtenirPuissance()
				+ "<br><br>"

				+ this.partie.obtenirJoueur(1).obtenirPersonnage(2)
						.obtenirNom()
				+ "<br>Vie : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(2)
						.obtenirVie()
				+ " / "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(2)
						.obtenirVie()
				+ "<br>Capacité de déplacement : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(2)
						.obtenirNombreDeplacement()
				+ "<br>Puissance : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(2)
						.obtenirPuissance()
				+ "<br><br>"
				
				
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(3)
						.obtenirNom()
				+ "<br>Vie : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(3)
						.obtenirVie()
				+ " / "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(3)
						.obtenirVie()
				+ "<br>Capacité de déplacement : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(3)
						.obtenirNombreDeplacement()
				+ "<br>Puissance : "
				+ this.partie.obtenirJoueur(1).obtenirPersonnage(3)
						.obtenirPuissance() + "<br><br>");
	}

	public void modifierPersonnageCourant(Personnage perso) {
		this.personnage = perso;
	}

	public void modifierACliquerSurBoutonDeplacer(boolean modif) {
		this.ACliquerSurBoutonDeplacer = modif;
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

}
