package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/** Bouton qui permet d'indiquer quand le joueur souhaite effectuer un deplacement*/
@SuppressWarnings("serial")
public class BoutonDeplacer extends JButton implements ActionListener{
	
	private InterfacePartie ecran;

	public BoutonDeplacer(final InterfacePartie ecranEnCours){
		
		super("Deplacer");
		this.ecran = ecranEnCours;
		
		this.setPreferredSize(new Dimension(400,50));
		this.setEnabled(false);
		
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(!ecran.obtenirACliquerSurBoutonDeplacer()){
			ecran.estEnModeAttaque(false);
			ecran.modifierACliquerSurBoutonDeplacer(true);
		}
		
	}

}
