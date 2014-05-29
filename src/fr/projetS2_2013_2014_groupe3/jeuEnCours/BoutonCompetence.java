package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import fr.projetS2_2013_2014_groupe3.competences.Competence;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class BoutonCompetence extends JButton implements ActionListener{
	
	private Fenetre fen;
	
	private Partie partie;
	
	private MenuAttaque ecran;
	
	private Personnage perso;
	
	private Competence compe;
	
	public BoutonCompetence(Fenetre fen, Partie partie,MenuAttaque menu, Personnage perso, Competence compe){
		
		this.fen = fen;
		this.partie = partie;
		this.ecran = menu;
		this.perso = perso;
		this.compe = compe;
		this.addActionListener(this);
		
		InitGUI();
	}

	private void InitGUI() {
		
		this.setPreferredSize(new Dimension(400,50));
		this.setText(this.compe.toString());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		this.ecran.modifierCompetenceVoulantEtreLancer(this.compe);
		/*
		this.perso.utiliserCompetence(this.compe, this.ecran.obtenirCible(), this.perso);
		this.ecran.modifierMenuAttaqueEnMenuJoueur();
		this.ecran.modifierEstEnModeAttaque();
		this.ecran.refreshInterfacePartie();
		*/
	}

}
