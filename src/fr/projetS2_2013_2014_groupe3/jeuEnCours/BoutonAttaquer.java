package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/** Bouton servant quand le joueur souhaite attaquer*/
@SuppressWarnings("serial")
public class BoutonAttaquer extends JButton implements ActionListener{
	
	private InterfacePartie ecran;

	public BoutonAttaquer(InterfacePartie ecranEnCours) {
		
		super("Attaquer");
		this.ecran = ecranEnCours;
		
		this.setPreferredSize(new Dimension(400,50));
		this.setEnabled(false);
		
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		this.ecran.modifierACliquerSurBoutonDeplacer(false);
		this.ecran.estEnModeAttaque(true);
		this.ecran.modifierMenuJoueurEnMenuAttaque(this.ecran.obtenirPersonnageCourant());
	}

}
