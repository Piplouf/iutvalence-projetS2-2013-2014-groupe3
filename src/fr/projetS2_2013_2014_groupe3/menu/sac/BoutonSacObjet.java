package fr.projetS2_2013_2014_groupe3.menu.sac;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Objet;
import fr.projetS2_2013_2014_groupe3.jeu.ObjetVide;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.TypeObjet;

/** Bouton qui contient un objet et qui si on clique dessus le met en objet courant*/
@SuppressWarnings("serial")
public class BoutonSacObjet extends JButton implements ActionListener {

	private Partie partie;

	private MenuSac ecran;

	private Objet objet;

	private int nombreObjet;

	public BoutonSacObjet(Partie partie, MenuSac menuSac,
			Objet objet) {

		this.partie = partie;
		this.ecran = menuSac;
		this.objet = objet;
		this.obtenirNombreDObjetDansLaPile();
		this.addActionListener(this);

		InitGUI();

	}

	/** Initialise l'interface graphique */
	private void InitGUI() {

		this.setPreferredSize(new Dimension(375, 80));
		this.setText(this.objet.getNom() + " * "
				+ Integer.toString(this.nombreObjet));
	}

	/** Reinitialise l'interface graphique */
	public void refresh() {
		
		if(this.nombreObjet == 1){
			this.ecran.modifierObjetCourant(new ObjetVide());
			this.ecran.enleverBouton(this);
			this.ecran.afficherObjetCourantSelectionner();
			this.ecran.degriserTousLesPersos();
			this.setVisible(false);
		}
		else{
		this.obtenirNombreDObjetDansLaPile();
		this.setText(this.objet.getNom() + " * "
				+ Integer.toString(this.nombreObjet));
		}
	}
	
	
	/** Permet d'obtenir le nombre d'objet d'un type restant dans le sac*/
	public void obtenirNombreDObjetDansLaPile(){
		this.nombreObjet = this.partie.obtenirJoueurCourant().obtenirSac().lotObjets
				.get(this.partie.obtenirJoueurCourant().obtenirSac()
						.obtenirIndexCollectionObjet(this.objet)).size();
	}

	/** Permet d'utiliser l'objet courant*/
	private void utiliserObjet() {

		if (this.objet.getTypeObjet() == TypeObjet.DEFENSIF)
			this.ecran
					.griserLesPersonnagesSurLesquelsLObjetNEstPasApplicable(this.partie
							.obtenirNumeroJoueurInverse());
		else
			this.ecran
					.griserLesPersonnagesSurLesquelsLObjetNEstPasApplicable(this.partie
							.obtenirNumJoueur());

		this.ecran.modifierObjetCourant(this.objet);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.utiliserObjet();
		this.ecran.afficherObjetCourantSelectionner();
	}

}
