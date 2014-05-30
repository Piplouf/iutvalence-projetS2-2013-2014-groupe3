package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;

import fr.projetS2_2013_2014_groupe3.competences.BouleDeFeu;
import fr.projetS2_2013_2014_groupe3.competences.Competence;
import fr.projetS2_2013_2014_groupe3.competences.Embrasement;
import fr.projetS2_2013_2014_groupe3.competences.Laser;
import fr.projetS2_2013_2014_groupe3.competences.PluieGuerisseuse;
import fr.projetS2_2013_2014_groupe3.competences.Poison;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;

/** Classe spécifique à l'ihm qui lie une image à un personnage*/
public class PersonnageMenu {
	
	private ImageIcon image;
	
	private Personnage perso;
	
	public PersonnageMenu(){
		
		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		
		for(int j =0; j < Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT; j++){
			compe[j] = new BouleDeFeu();
		}
			
		this.perso = new Personnage("Null",0,0,0,0,compe,2);
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
	
	/** Permet d'obtenir tous les personnages du jeu
	 * C'est ici que sont initialisés tous les personnages du jeu*/
	public Set<PersonnageMenu> listeHeros(Partie partie,int numeroJoueur){
		Set<PersonnageMenu> persos = new HashSet<PersonnageMenu>();
		
		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		
		compe[0] = new Poison(partie);
		compe[1] = new Embrasement(partie);
		compe[2] = new Laser(partie);
		compe[3] = new PluieGuerisseuse(partie);
		
			persos.add(new PersonnageMenu(new Personnage("Riven",100,100,30,3,compe,numeroJoueur), new ImageIcon("img/Perso/Riven.jpg")));
			persos.add(new PersonnageMenu(new Personnage("Kennen",100,100,30,3,compe, numeroJoueur), new ImageIcon("img/Perso/Kennen.png")));
			persos.add(new PersonnageMenu(new Personnage("Jayce",100,100,30,3,compe, numeroJoueur), new ImageIcon("img/Perso/Jayce.png")));
			persos.add(new PersonnageMenu(new Personnage("Sivir",100,100,30,3,compe, numeroJoueur), new ImageIcon("img/Perso/Sivir.png")));
			persos.add(new PersonnageMenu(new Personnage("Urgot",100,100,30,3,compe, numeroJoueur), new ImageIcon("img/Perso/Urgot.png")));
			persos.add(new PersonnageMenu(new Personnage("Jinx",100,100,30,3,compe, numeroJoueur), new ImageIcon("img/Perso/Jinx.jpg")));
			persos.add(new PersonnageMenu(new Personnage("Leona",100,100,30,3,compe, numeroJoueur), new ImageIcon("img/Perso/Leona.png")));
			persos.add(new PersonnageMenu(new Personnage("Lee Sin",100,100,30,3,compe, numeroJoueur), new ImageIcon("img/Perso/LeeSin.png")));
			persos.add(new PersonnageMenu(new Personnage("Thresh",100,100,30,3,compe, numeroJoueur), new ImageIcon("img/Perso/Thresh.jpg")));
			persos.add(new PersonnageMenu(new Personnage("Teemo",100,100,30,3,compe,numeroJoueur), new ImageIcon("img/Perso/Teemo.png")));
			
		return persos;
	}

	/** Permet de changer le personnage */
	public void modifierPerso(Personnage personnage) {
		this.perso = personnage;
		
	}
	
	/** Donne l'image associée au personnage*/
	public ImageIcon rechercheImagePersonnage(Personnage personnage, Partie partie){
		
		ImageIcon image = new ImageIcon();
		for(PersonnageMenu perso : this.listeHeros(partie, 2)){
			if(perso.obtenirPerso().obtenirNom() == personnage.obtenirNom())
				image = perso.obtenirImage();
		}
		return image;
	}

}
