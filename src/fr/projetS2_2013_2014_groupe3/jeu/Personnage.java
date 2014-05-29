package fr.projetS2_2013_2014_groupe3.jeu;

import fr.projetS2_2013_2014_groupe3.competences.Competence;


public class Personnage extends Perso {
	
	private int vie;
	
	private String nom;
	
	private int vieMax;
	
	private int energie;
	
	private int energieMax;
	
	private int puissance;
	
	private Competence[] competences;
	
	private int capaciteDeDeplacement;
	
	private int numeroDAppartenanceJoueur;
	
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
	public Personnage(String nom , int vie,int energie,int puissance, 
			int capaciteDeplacement, Competence[] competencesVoulues, int numeroJoueur){
		this.nom = nom;
		this.vie = vie;
		this.vieMax = vie;
		this.energie = energie;
		this.energieMax = energie;
		this.puissance = puissance;
		this.competences = new Competence[NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		this.competences = competencesVoulues;
		this.numeroDAppartenanceJoueur = numeroJoueur;
		this.capaciteDeDeplacement = capaciteDeplacement;
	}
	
	public void utiliserCompetence(Competence compe, Position cible, Personnage lanceur){
		compe.utiliserCompetence(lanceur, cible);
	}
	
	public int obtenirNumeroDAppartenanceJoueur(){
		return this.numeroDAppartenanceJoueur;
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
	
	public int obtenirEnergie(){
		return this.energie;
	}
	
	public int obtenirEnergieMax(){
		return this.energieMax;
	}
	
	public Competence obtenirCompetence(int num){
		return this.competences[num];
	}
	
	public Competence[] obtenirCompetences(){
		Competence[] toutesLesCompes = new Competence[4];
		int i = 0;
		
		for(Competence compe : this.competences)
			toutesLesCompes[i++] = compe;
		return toutesLesCompes;
	}
	
	public int obtenirPuissance(){
		return this.puissance;
	}
	
	public int obtenirNombreDeplacement(){
		return this.capaciteDeDeplacement;
	}
	
	public String toString(){
		return(this.nom
				+ "<br>Vie : "
				+ this.vie
				+ " / "
				+ this.vieMax
				+ "<br>Energie : "
				+ this.energie
				+ " / "
				+ this.energieMax
				+ "<br>Capacité de déplacement : "
				+ this.capaciteDeDeplacement
				+ "<br>Puissance : "
				+ this.puissance);
	}
	
	public void rajouterVie(int vie){
		if(this.vie + vie > this.vieMax)
			this.vie = this.vieMax;
	}
	
	public void enleverVie(int vie){
		if(this.vie - vie < 0)
			this.vie = 0;
		else
			this.vie -= vie;
	}
	
}
