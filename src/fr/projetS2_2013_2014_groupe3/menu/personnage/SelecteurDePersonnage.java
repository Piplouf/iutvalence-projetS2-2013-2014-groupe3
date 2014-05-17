package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class SelecteurDePersonnage extends JPanel{
	
	private Set<PersonnageMenu> persos;
	
	private MenuPersonnage ecranPerso;
	
	private JPanelPerso tousLesPersos;
	
	public SelecteurDePersonnage(MenuPersonnage ecran){
		
		this.ecranPerso = ecran;
		this.persos = new HashSet();
		
		this.persos = new PersonnageMenu().listeHeros();
		
		this.tousLesPersos = new JPanelPerso();
		
		GridLayout grillePerso = new GridLayout(2,5);
		grillePerso.setHgap(5);
		grillePerso.setVgap(5);
		
		tousLesPersos.setLayout(grillePerso);
		
		for(PersonnageMenu perso : new PersonnageMenu().listeHeros()){
			this.tousLesPersos.add(new BoutonPersonnage(perso, ecran, 120, 120));	
		}
		
		this.add(tousLesPersos);
	}

	public void reactiverBouton(PersonnageMenu perso) {
		
			for(BoutonPersonnage boutonPerso : this.tousLesPersos.obtenirComposantsBoutons()){
				if(boutonPerso.obtenirPersonnageMenu().obtenirPerso().obtenirNom() == perso.obtenirPerso().obtenirNom())
					boutonPerso.setEnabled(true);
			}
		}
}

