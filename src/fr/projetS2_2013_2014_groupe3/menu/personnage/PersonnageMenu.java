package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.ImageIcon;

import fr.projetS2_2013_2014_groupe3.jeu.BouleDeFeu;
import fr.projetS2_2013_2014_groupe3.jeu.Competence;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;


public class PersonnageMenu {
	
	private ImageIcon image;
	
	private Personnage perso;
	
	public PersonnageMenu(){
		
		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		
		for(int j =0; j < Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT; j++){
			compe[j] = new BouleDeFeu();
		}
			
		this.perso = new Personnage("Null",0,0,0,compe);
		this.image = new ImageIcon("");
	}
	
	public PersonnageMenu(Personnage perso, ImageIcon image){
		this.perso = perso;
		this.image = image;
	}
	
	public Personnage obtenirPerso(){
		return this.perso;
	}
	
	public ImageIcon obtenirImage(){
		return this.image;
	}
	
	public Set<PersonnageMenu> listeHeros(){
		Set<PersonnageMenu> persos = new HashSet<PersonnageMenu>();
		
		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		
		for(int j =0; j < Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT; j++){
			compe[j] = new BouleDeFeu();
		}
		
			persos.add(new PersonnageMenu(new Personnage("Riven",100,30,3,compe), new ImageIcon("img/Perso/Riven.jpg")));
			persos.add(new PersonnageMenu(new Personnage("Kennen",100,30,3,compe), new ImageIcon("img/Perso/Kennen.png")));
			persos.add(new PersonnageMenu(new Personnage("Jayce",100,30,3,compe), new ImageIcon("img/Perso/Jayce.png")));
			persos.add(new PersonnageMenu(new Personnage("Sivir",100,30,3,compe), new ImageIcon("img/Perso/Sivir.png")));
			persos.add(new PersonnageMenu(new Personnage("Urgot",100,30,3,compe), new ImageIcon("img/Perso/Urgot.png")));
			persos.add(new PersonnageMenu(new Personnage("Jinx",100,30,3,compe), new ImageIcon("img/Perso/Jinx.jpg")));
			persos.add(new PersonnageMenu(new Personnage("Leona",100,30,3,compe), new ImageIcon("img/Perso/Leona.png")));
			persos.add(new PersonnageMenu(new Personnage("Lee Sin",100,30,3,compe), new ImageIcon("img/Perso/LeeSin.png")));
			persos.add(new PersonnageMenu(new Personnage("Thresh",100,30,3,compe), new ImageIcon("img/Perso/Thresh.jpg")));
			persos.add(new PersonnageMenu(new Personnage("Teemo",100,30,3,compe), new ImageIcon("img/Perso/Teemo.png")));
			
		return persos;
	}

	public void modifierPerso(Personnage personnage) {
		this.perso = personnage;
		
	}
	
	public ImageIcon rechercheImagePersonnage(Personnage personnage){
		
		ImageIcon image = new ImageIcon();
		for(PersonnageMenu perso : this.listeHeros()){
			if(perso.obtenirPerso().obtenirNom() == personnage.obtenirNom())
				image = perso.obtenirImage();
		}
		return image;
	}

}
