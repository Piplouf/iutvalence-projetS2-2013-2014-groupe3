package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Color;
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

/** Bouton le plus important du jeu car il réagit en fonction de tous les autres évements qui se sont déroulés*/
@SuppressWarnings("serial")
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

		InitGUI();

		this.addActionListener(this);
		this.addMouseListener(this);

	}

	/** Initialise l'interface graphique */
	public void InitGUI() {

		this.numeroJoueur = this.uneCase.obtenirNumeroJoueur();
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
			if(((Personnage)this.uneCase.estOccupe()).obtenirVie() == 0)
				this.setEnabled(false);
		} else {
			this.image = new ImageIcon("img/case.png");
			this.setBorder(UIManager.getBorder("Button.border"));
		}
		// this.setText(this.position.toString());
		if (this.uneCase.estPleine()) {
			this.setEnabled(false);
			this.setBackground(Color.BLACK);
			this.setBorderPainted(false);
		}
		this.setIcon(this.image);
	}

	/** Effectue le deplacement d'un personnage */
	public void effectuerDeplacement() {

		// Bouton qu'il va falloir modifier ensuite
		BoutonCarteEnJeu bouton = this.ecran.obtenirCarteModeliser()
				.obtenirBoutonsAPosition(
						this.partie
								.obtenirCarte()
								.obtenirCasePersonnage(
										this.ecran.obtenirPersonnageCourant())
								.obtenirPosition());
		boolean deplacementAReussi = this.partie.obtenirCarte()
				.deplacerPersonnage(this.position,
						this.ecran.obtenirPersonnageCourant(),
						this.partie.obtenirNumJoueur());
		if (deplacementAReussi) {
			this.partie.modifierNumeroJoueur();
			bouton.InitGUI();
			this.ecran.obtenirCarteModeliser()
					.obtenirBoutonsAPosition(this.position).InitGUI();
			this.partie.redonnerEnergieATousLesPersonnages();
		} else
			this.ecran.modifierACliquerSurBoutonDeplacer(false);
	}

	/** Change les bordures du bouton pour indiquer que cette zone sera attaquer */
	public void modifierEnZoneQuiVaEtreAttaquer(boolean test) {
		if (test)
			this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		else if (this.uneCase.estOccupe() instanceof PersonnageVide)
			this.setBorder(UIManager.getBorder("Button.border"));
		else {
			if (this.numeroJoueur == 1)
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

	/**
	 * Méthode appeler lorsque le joueur clique sur un bouton en mode attaque
	 * Utilise la compétence voulu
	 */
	public void estEnModeAttaque() {

		// Si l'attaque courante est une vrai compétence on execute le lancement de celle-ci sinon on ne fait rien//
		if (!(ecran.obtenirMenuAttaque().obtenirCompetenceVoulantEtreLancer() instanceof CompetenceVide)
				&& this.ecran.obtenirMenuAttaque()
						.obtenirCompetenceVoulantEtreLancer().obtenirCout() <= this.ecran
						.obtenirPersonnageCourant().obtenirEnergie()) {
			ecran.obtenirMenuAttaque()
					.obtenirCompetenceVoulantEtreLancer()
					.utiliserCompetence(
							this.ecran.obtenirMenuAttaque().obtenirPerso(),
							this.position);
			this.ecran.obtenirPersonnageCourant()
					.baisserEnergie(
							this.ecran.obtenirMenuAttaque()
									.obtenirCompetenceVoulantEtreLancer()
									.obtenirCout());
			this.ecran.modifierMenuAttaqueEnMenuJoueur();
			this.ecran.estEnModeAttaque(false);
			if (this.partie.estGagnee())
				this.partieEstGagnee();
			else {
				this.partie.redonnerEnergieATousLesPersonnages();
				this.partie.modifierNumeroJoueur();
				this.ecran.refresh();
			}
		}
	}

	/**
	 * Lorsqu'un joueur gagne la méthode appelle la méthode qui va bloquer le
	 * jeu
	 */
	private void partieEstGagnee() {
		this.ecran.partieEstGagnee();

	}

	public void rendreBoutonNormal(){
		this.setEnabled(false);
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

		if (ecran.obtenirEstEnModeAttaque())
			this.estEnModeAttaque();

		if (ecran.obtenirACliquerSurBoutonDeplacer()) {
			this.effectuerDeplacement();
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	/** Si le joueur est en mode attaque affiche la zone qu'il va touché avec son attaque quand il rentre dans la case*/
	public void mouseEntered(MouseEvent arg0) {

		if (ecran.obtenirEstEnModeAttaque()) {
			if (!(ecran.obtenirMenuAttaque()
					.obtenirCompetenceVoulantEtreLancer() instanceof CompetenceVide))
				this.ecran.afficherZoneAffecterParCompetences(ecran
						.obtenirMenuAttaque()
						.obtenirCompetenceVoulantEtreLancer()
						.retournerZoneAffecterParAttaque(
								this.ecran.obtenirMenuAttaque().obtenirPerso(),
								this.position));
		}

	}

	@Override
	/** Enleve l'affichage de la zone quand le joueur sort de la case*/
	public void mouseExited(MouseEvent arg0) {

		if (ecran.obtenirEstEnModeAttaque()) {
			if (!(ecran.obtenirMenuAttaque()
					.obtenirCompetenceVoulantEtreLancer() instanceof CompetenceVide))
				this.ecran.retirerZoneAffecterParCompetences(ecran
						.obtenirMenuAttaque()
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
