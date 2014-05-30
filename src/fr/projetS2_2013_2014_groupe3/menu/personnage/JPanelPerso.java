package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.Component;
import java.util.HashSet;

import javax.swing.JPanel;

/** Classe héritant d'une JPanel contenant une méthode que j'ai rajouté*/
@SuppressWarnings("serial")
public class JPanelPerso extends JPanel{
	
	
	public JPanelPerso(){
		super();
	}
	
	/** Ne renvoi que les boutons personnages contenu dans un JPanel */
	public BoutonPersonnage[] obtenirComposantsBoutons(){
		
		HashSet<BoutonPersonnage> liste = new HashSet<BoutonPersonnage>();
		for(Component compo : this.getComponents()){
			if(compo instanceof BoutonPersonnage)
				liste.add((BoutonPersonnage) compo);
		}
		
		BoutonPersonnage[] listeBoutons = new BoutonPersonnage[liste.size()];
		int i = 0;
		for(BoutonPersonnage bouton : liste)
			listeBoutons[i++] = bouton;
		return listeBoutons;
	}
}
