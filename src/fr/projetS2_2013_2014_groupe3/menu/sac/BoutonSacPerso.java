package fr.projetS2_2013_2014_groupe3.menu.sac;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.menu.personnage.PersonnageMenu;


@SuppressWarnings("serial")
/** Bouton contenant les persos existant*/
public class BoutonSacPerso extends JButton implements ActionListener{
	
	private MenuSac ecran;
	
	private Partie partie;
	
	private Personnage perso;
	
	private int numeroJoueur;
	
	public BoutonSacPerso(MenuSac ecranEnCours, Partie partie, Personnage perso, int num){
		
		this.ecran = ecranEnCours;
		this.partie = partie;
		this.perso = perso;
		this.numeroJoueur = num;
		this.addActionListener(this);
		InitGUI();
	}

	/** Initialise la partie graphique*/
	private void InitGUI() {
		this.setPreferredSize(new Dimension(120,120));
		this.setIcon(new PersonnageMenu().rechercheImagePersonnage(this.perso, this.partie));
		
	}
	
	public int numeroJoueur(){
		return this.numeroJoueur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.partie.obtenirJoueurCourant().obtenirSac().utiliserObjet(this.ecran.obtenirObjetCourant(), this.perso);
		this.ecran.refresh();
	}

}
