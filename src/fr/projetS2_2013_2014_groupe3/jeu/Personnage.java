package fr.projetS2_2013_2014_groupe3.jeu;


public class Personnage extends Perso {
	
	private int vie;
	
	private String nom;
	
	private int vieMax;
	
	private int puissance;
	
	private Competence[] competences;
	
	private int capaciteDeDeplacement;
	
	public final static int NOMBRE_DE_COMPETENCES_PAR_DEFAUT = 4;
	
	public final static int NOMBRE_TOTAL_DE_PERSONNAGES = 10;
	
	/**
	 * Constructeur d'un personnage
	 * @param nom nom
	 * @param vie vie
	 * @param puissance puissance
	 * @param capaciteDeplacement nombre de deplacement possible
	 * @param competencesVoulues les compétences voulues
	 */
	public Personnage(String nom , int vie,int puissance, 
			int capaciteDeplacement, Competence[] competencesVoulues){
		this.nom = nom;
		this.vie = vie;
		this.vieMax = vie;
		this.puissance = puissance;
		this.competences = new Competence[NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		this.competences = competencesVoulues;
		this.capaciteDeDeplacement = capaciteDeplacement;
	}
	
	public String obtenirNom(){
		return this.nom;
	}
	
	public int obtenirVie(){
		return vie;
	}
	
	public int obtenirVieMax(){
		return this.vieMax;
	}
	
	public Competence obtenirCompetence(int num){
		return this.competences[num];
	}
	
	public int obtenirPuissance(){
		return this.puissance;
	}
	
	public int obtenirNombreDeplacement(){
		return this.capaciteDeDeplacement;
	}
	
	public void enleverVie(int vie){
		if(this.vie - vie < 0)
			this.vie = 0;
		else
			this.vie -= vie;
	}
	
}
