package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import fr.projetS2_2013_2014_groupe3.competences.Competence;

/** Bouton qui permet de changer la compétence courante*/
@SuppressWarnings("serial")
public class BoutonCompetence extends JButton implements ActionListener{
	
	private MenuAttaque ecran;
	
	private Competence compe;
	
	public BoutonCompetence(MenuAttaque menu,Competence compe){
		
		this.ecran = menu;
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
