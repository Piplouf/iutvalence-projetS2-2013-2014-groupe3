package fr.projetS2_2013_2014_groupe3.menu.carte;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.exceptions.NumeroJoueurErronne;
import fr.projetS2_2013_2014_groupe3.exceptions.PositionErronne;
import fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes.CarteNumeroUn;
import fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes.CarteNumeroCinq;
import fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes.CarteNumeroDeux;
import fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes.CarteNumeroQuatre;
import fr.projetS2_2013_2014_groupe3.menu.carte.toutesLesCartes.CarteNumeroTrois;

/** Panel contenant toutes les cartes du jeu et que le joueur pourra choisir*/
@SuppressWarnings("serial")
public class SelecteurDeCarte extends JPanel {

	private MenuCarte ecran;

	public SelecteurDeCarte(MenuCarte interfaceCarte) throws PositionErronne, NumeroJoueurErronne{
		
		this.ecran = interfaceCarte;
		
		GridLayout grilleCarte = new GridLayout(1,5);
		grilleCarte.setHgap(5);
		grilleCarte.setVgap(5);
		
		JPanel toutesLesCartes = new JPanel();
		
		toutesLesCartes.setLayout(grilleCarte);
		
		toutesLesCartes.add(new BoutonCarte(ecran, new CarteMenu(new CarteNumeroUn(ecran.obtenirPartie()),new ImageIcon(""),"CarteUne")));	
		toutesLesCartes.add(new BoutonCarte(ecran, new CarteMenu(new CarteNumeroDeux(ecran.obtenirPartie()),new ImageIcon(""),"CarteDeux")));
		toutesLesCartes.add(new BoutonCarte(ecran, new CarteMenu(new CarteNumeroTrois(ecran.obtenirPartie()),new ImageIcon(""),"CarteTrois")));
		toutesLesCartes.add(new BoutonCarte(ecran, new CarteMenu(new CarteNumeroQuatre(ecran.obtenirPartie()),new ImageIcon(""),"CarteQuatre")));
		toutesLesCartes.add(new BoutonCarte(ecran, new CarteMenu(new CarteNumeroCinq(ecran.obtenirPartie()),new ImageIcon(""),"CarteCinq")));
		
		this.add(toutesLesCartes);
		
		
	}

}
