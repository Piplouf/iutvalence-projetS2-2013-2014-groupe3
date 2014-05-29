package fr.projetS2_2013_2014_groupe3.menu.sac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.projetS2_2013_2014_groupe3.jeu.Joueur;
import fr.projetS2_2013_2014_groupe3.jeu.Objet;
import fr.projetS2_2013_2014_groupe3.jeu.ObjetVide;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeuEnCours.InterfacePartie;
import fr.projetS2_2013_2014_groupe3.menu.personnage.JPanelPerso;
import fr.projetS2_2013_2014_groupe3.menu.personnage.MenuPersonnage;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class MenuSac extends JPanel implements KeyListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Fenetre fen;

	private Partie partie;
	
	private JPanelPersoSac conteneurBoutons;
	
	private JPanelPersoSac conteneurPersosJoueur1;
	private JPanelPersoSac conteneurPersosJoueur2;
	
	private JLabel etatPersoJoueur1;
	private JLabel etatPersoJoueur2;
	private JLabel espaceEntreHautEtBas;
	
	private JButton retour;
	
	private static Objet objetCourant;

	public MenuSac(Fenetre fen, Partie partie) {

		this.fen = fen;
		this.partie = partie;
		MenuSac.objetCourant = new ObjetVide();
		InitGUI();
	}

	public void InitGUI() {
		
		
		this.etatPersoJoueur1 = new JLabel();
		this.etatPersoJoueur2 = new JLabel();
		this.retour = new JButton("Retour");
		this.retour.addActionListener(this);
		
		JPanel conteneurFinal = new JPanel();
		conteneurFinal.setLayout(new BorderLayout());

		JPanel global = new JPanel();
		global.setLayout(new BoxLayout(global, BoxLayout.Y_AXIS));
		
		JPanel haut = new JPanel();
		haut.setLayout(new BoxLayout(haut, BoxLayout.PAGE_AXIS));
		
		JPanel bas = new JPanel();
		
		JPanel ouest = new JPanel();
		JPanel est = new JPanel();
		JPanel sud = new JPanel();
		
		this.etatPersoJoueur1.setPreferredSize(new Dimension(560, 500));
		this.etatPersoJoueur1.setFont(new Font("Arial", Font.BOLD, 14));
		this.etatPersoJoueur1.setHorizontalAlignment(JLabel.CENTER);
		this.etatPersoJoueur1.setVerticalAlignment(JLabel.CENTER);
		
		this.etatPersoJoueur2.setPreferredSize(new Dimension(560, 500));
		this.etatPersoJoueur2.setFont(new Font("Arial", Font.BOLD, 14));
		this.etatPersoJoueur2.setHorizontalAlignment(JLabel.CENTER);
		this.etatPersoJoueur2.setVerticalAlignment(JLabel.CENTER);
		
		ouest.add(this.etatPersoJoueur1);
		est.add(this.etatPersoJoueur2);
		
		this.afficherEtatPersoJoueurs();
		
		JPanel texteJ1 = new JPanel();
		JPanel texteJ2 = new JPanel();
		JPanel texteObjet = new JPanel();
		
		JLabel joueur1 = new JLabel("Joueur 1");
		JLabel joueur2 = new JLabel("Joueur 2");
		
		joueur1.setForeground(Color.RED);
		joueur1.setFont(new Font("Arial", Font.BOLD, 14));
		joueur1.setHorizontalAlignment(JLabel.CENTER);
		
		joueur2.setForeground(Color.BLUE);
		joueur2.setFont(new Font("Arial", Font.BOLD, 14));
		joueur2.setHorizontalAlignment(JLabel.CENTER);
		
		texteJ1.add(joueur1);
		texteJ2.add(joueur2);
		
		JLabel espace = new JLabel();
		espace.setPreferredSize(new Dimension(1,80*(5 - this.partie.obtenirJoueurCourant().obtenirSac().lotObjets.size())));
		
		this.espaceEntreHautEtBas = new JLabel();
		this.espaceEntreHautEtBas.setPreferredSize(new Dimension(400,30));
		this.espaceEntreHautEtBas.setFont(new Font("Arial", Font.BOLD, 14));
		this.espaceEntreHautEtBas.setHorizontalAlignment(JLabel.CENTER);
		
		texteObjet.add(this.espaceEntreHautEtBas);
		this.afficherObjetCourantSelectionner();
		
		this.conteneurBoutons = new JPanelPersoSac();
		this.conteneurPersosJoueur1 = new JPanelPersoSac();
		this.conteneurPersosJoueur2 = new JPanelPersoSac();
		
		this.retour.setPreferredSize(new Dimension(400,50));
		sud.add(this.retour);

		GridLayout grilleBoutons = new GridLayout(this.partie.obtenirJoueurCourant().obtenirSac().lotObjets.size(),1);
		grilleBoutons.setVgap(5);
		
		GridLayout grillePersosJoueur1 = new GridLayout(1,4);
		grillePersosJoueur1.setVgap(5);
		grillePersosJoueur1.setHgap(5);
		
		GridLayout grillePersosJoueur2 = new GridLayout(1,4);
		grillePersosJoueur2.setVgap(5);
		grillePersosJoueur2.setHgap(5);
		
		this.conteneurBoutons.setLayout(grilleBoutons);
		this.conteneurPersosJoueur1.setLayout(grillePersosJoueur1);
		this.conteneurPersosJoueur2.setLayout(grillePersosJoueur2);

		Iterator<ArrayList<Objet>> iterateurDeCollectionsDObjets = this.partie
				.obtenirJoueurCourant().obtenirSac().lotObjets.iterator();
		
		//Boucle qui crée autant de bouton que de collections d'objets contenu dans la liste
		while (iterateurDeCollectionsDObjets.hasNext()) {
			
			ArrayList<Objet> liste = iterateurDeCollectionsDObjets.next();
			Objet objetEnCours = liste.get(0);
				
			this.conteneurBoutons.add(new JPanel().add(new BoutonSacObjet(this.fen,
					this.partie,this,objetEnCours)));
		}
		
		for(Personnage perso : this.partie.obtenirJoueur(0).obtenirPersonnageDUneEquipe()){
			this.conteneurPersosJoueur1.add(new JPanel().add(new BoutonSacPerso(this,this.partie,perso,1)));
		}
		
		for(Personnage perso : this.partie.obtenirJoueur(1).obtenirPersonnageDUneEquipe()){
			this.conteneurPersosJoueur2.add(new JPanel().add(new BoutonSacPerso(this,this.partie,perso,2)));
		}
		
		haut.add(new JPanel().add(espace));
		haut.add(texteJ1);
		haut.add(this.conteneurPersosJoueur1);
		haut.add(texteJ2);
		haut.add(this.conteneurPersosJoueur2);
		haut.add(texteObjet);
		
		bas.add(this.conteneurBoutons);
		
		global.add(haut);
		global.add(bas);
		
		conteneurFinal.add(global, BorderLayout.CENTER);
		conteneurFinal.add(ouest, BorderLayout.WEST);
		conteneurFinal.add(est, BorderLayout.EAST);
		conteneurFinal.add(sud, BorderLayout.SOUTH);
			
		this.add(conteneurFinal);
		
		this.addKeyListener(this);
	}
	
	public void refresh(){
		
	for(BoutonSacObjet bouton : this.conteneurBoutons.obtenirComposantsBoutonsSacOjet())
		bouton.refresh();
	
	this.afficherEtatPersoJoueurs();
	}
	
	public void afficherObjetCourantSelectionner(){
		if(this.obtenirObjetCourant().getNom() != "Vide")
			this.espaceEntreHautEtBas.setText(this.obtenirObjetCourant().getNom());
		else
			this.espaceEntreHautEtBas.setText("Aucun objet sélectionner");
	}

	public void griserLesPersonnagesSurLesquelsLObjetNEstPasApplicable(int numero){
		
		for(BoutonSacPerso perso : this.conteneurPersosJoueur1.obtenirComposantsBoutons()){
			if(perso.numeroJoueur() == numero)
				perso.setEnabled(false);
		}
		
		for(BoutonSacPerso perso : this.conteneurPersosJoueur2.obtenirComposantsBoutons()){
			if(perso.numeroJoueur() == numero)
				perso.setEnabled(false);
		}
	}
	
	public void degriserTousLesPersos(){
		
		for(BoutonSacPerso perso : this.conteneurPersosJoueur1.obtenirComposantsBoutons())
			perso.setEnabled(true);
		for(BoutonSacPerso perso : this.conteneurPersosJoueur2.obtenirComposantsBoutons())
			perso.setEnabled(true);
	}
	
	public void enleverBouton(BoutonSacObjet bouton){
		this.conteneurBoutons.remove(bouton);
		this.conteneurBoutons.revalidate();
		this.validate();
	}

	public Objet obtenirObjetCourant(){
		return MenuSac.objetCourant;
	}
	public void modifierObjetCourant(Objet objet){
		MenuSac.objetCourant = objet;
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

	@Override
	public void keyPressed(KeyEvent event) {
		
		 int source = event.getKeyCode();
		 if(source == KeyEvent.VK_SHIFT || source == KeyEvent.VK_ENTER)
			 this.fen.modifierPanneau(new InterfacePartie(this.fen, this.partie));
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		JComponent source = (JComponent) event.getSource();

		if (source == this.retour)
		{
			this.fen.modifierPanneau(
					new InterfacePartie(this.fen, this.fen.obtenirPartie()));
			return;
		}
		
	}
}
