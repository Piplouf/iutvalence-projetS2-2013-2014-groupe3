package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.GridLayout;

import javax.swing.JPanel;

/** Contient tous les personnages que nous voulons montrer au joueur et donc ceux qu'il pourra ajouter à son equipe*/
@SuppressWarnings("serial")
public class SelecteurDePersonnage extends JPanel{
	
	private MenuPersonnage ecranPerso;
	
	private JPanelPerso tousLesPersos;
	
	public SelecteurDePersonnage(MenuPersonnage ecran){
		
		this.ecranPerso = ecran;
		refresh();
	}
	
	/** Initialise ou refresh l'interface graphique*/
	public void refresh(){
		
		this.tousLesPersos = new JPanelPerso();
		
		GridLayout grillePerso = new GridLayout(2,5);
		grillePerso.setHgap(5);
		grillePerso.setVgap(5);
		
		tousLesPersos.setLayout(grillePerso);
		
		for(PersonnageMenu perso : new PersonnageMenu().listeHeros(this.ecranPerso.obtenirPartie(), this.ecranPerso.obtenirNumeroJoueur()+1)){
			this.tousLesPersos.add(new BoutonPersonnage(perso, this.ecranPerso, 120, 120));	
		}
		
		this.add(tousLesPersos);
	}

	/** Réactive un bouton lorsque le personnage qui était dans l'equipe viens d'etre retirer*/
	public void reactiverBouton(PersonnageMenu perso) {
		
			for(BoutonPersonnage boutonPerso : this.tousLesPersos.obtenirComposantsBoutons()){
				if(boutonPerso.obtenirPersonnageMenu().obtenirPerso().obtenirNom() == perso.obtenirPerso().obtenirNom())
					boutonPerso.setEnabled(true);
			}
		}
}

