package fr.projetS2_2013_2014_groupe3.menu.sac;

import java.awt.Component;
import java.util.HashSet;

import javax.swing.JPanel;

public class JPanelPersoSac extends JPanel {

	public JPanelPersoSac(){
		super();
	}
	
	public BoutonSacPerso[] obtenirComposantsBoutons(){
		
		HashSet<BoutonSacPerso> liste = new HashSet<BoutonSacPerso>();
		for(Component compo : this.getComponents()){
			if(compo instanceof BoutonSacPerso)
				liste.add((BoutonSacPerso) compo);
		}
		
		BoutonSacPerso[] listeBoutons = new BoutonSacPerso[liste.size()];
		int i = 0;
		for(BoutonSacPerso bouton : liste)
			listeBoutons[i++] = bouton;
		return listeBoutons;
	}
	
	public BoutonSacObjet[] obtenirComposantsBoutonsSacOjet(){
		
		HashSet<BoutonSacObjet> liste = new HashSet<BoutonSacObjet>();
		for(Component compo : this.getComponents()){
			if(compo instanceof BoutonSacObjet)
				liste.add((BoutonSacObjet) compo);
		}
		
		BoutonSacObjet[] listeBoutons = new BoutonSacObjet[liste.size()];
		int i = 0;
		for(BoutonSacObjet bouton : liste)
			listeBoutons[i++] = bouton;
		return listeBoutons;
	}
}
