package fr.projetS2_2013_2014_groupe3.jeu;

import fr.projetS2_2013_2014_groupe3.competences.Competence;

/** Classe des personnages */
public class Personnage extends Perso {
	
	/** La vie du personnage*/
	private int vie;
	/** Le nom du personnage*/
	private String nom;
	/** La vie maximum du personnage*/
	private int vieMax;
	/** L'energie du personnage*/
	private int energie;
	/** L'energie maximum du personnage*/
	private int energieMax;
	/** La puissance du personnage*/
	private int puissance;
	/** Les compétences du personnage*/
	private Competence[] competences;
	/** Le nombre de case maximum que le joueur pourra effectuer à chaque tour*/
	private int capaciteDeDeplacement;
	/** L'état (statut) du personnage*/
	private Etat etat;
	/** Le nombre de tour restant d'un etat particulier*/
	private int nombreDeTourEtat;
	/** Le numero d'appartenance du personnage au joueur*/
	private int numeroDAppartenanceJoueur;
	/** Constante définissant le nombre de compétences*/
	public final static int NOMBRE_DE_COMPETENCES_PAR_DEFAUT = 4;
	/** Constant définissant le nombre total de personnage existant*/
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
		this.etat = Etat.NORMAL;
		this.nombreDeTourEtat = 0;
		this.competences = new Competence[NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		this.competences = competencesVoulues;
		this.numeroDAppartenanceJoueur = numeroJoueur;
		this.capaciteDeDeplacement = capaciteDeplacement;
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
	
	/** Diminiue l'energie du joueur du cout indiqué */
	public void baisserEnergie(int cout){
		if(this.energie - 5 >= 0)
			this.energie -= cout;
		else
			this.energie = 0;
	}
	
	/** Remonte l'energie de 5 d'un personnage */
	public void remonterEnergie(){
		if(this.energie + 5 <= this.energieMax)
			this.energie += 5;
		else
			this.energie = this.energieMax;
	}
	
	public Competence[] obtenirCompetences(){
		return this.competences;
	}
	
	public int obtenirPuissance(){
		return this.puissance;
	}
	
	public int obtenirNombreDeplacement(){
		return this.capaciteDeDeplacement;
	}
	
	public Etat obtenirEtat(){
		return this.etat;
	}
	
	public void modifierEtat(Etat nouveauEtat){
		this.etat = nouveauEtat;
	}
	
	public int obtenirNombreDeTourEtat(){
		return this.nombreDeTourEtat;
	}
	
	/** Permet d'initialisé le nombre de tour que va duré un etat*/
	public void modifierNombreDeTourEtat(int nombre){
		this.nombreDeTourEtat = nombre;
	}
	
	/** Réduit le nombre de tour pendant lequel l'etat particulier va continuer*/
	public void decrementerNombreDeTourEtat(){
		this.nombreDeTourEtat--;
	}
	
	/** Renvoi une chaine de caractere correspondant à chaque etat possible*/
	public String retournerEtat(){

		if(this.etat == Etat.EMPOISONNE)
			return "Empoisonné";
		return "Normal";
	}
	
	/** Ajoute de la capacité de deplacement au personnage*/
	public void ajouterCapaciteDeDeplacement(int modif){
		this.capaciteDeDeplacement += modif;
	}
	
	/** Représentation du personnage en chaine de caracteres*/
	public String toString(){
		return("<html>"+this.nom
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
				+ this.puissance
				+ "<br>Etat : "
				+ this.retournerEtat());
	}
	
	/** Redonne de la vie à un personnage */
	public void rajouterVie(int vie){
		if(this.vie + vie > this.vieMax)
			this.vie = this.vieMax;
		else
			this.vie += vie;
	}
	
	/** Enleve de la vie à un personnage */
	public void enleverVie(int vie){
		if(this.vie - vie < 0)
			this.vie = 0;
		else
			this.vie -= vie;
	}
	
	/** Rédefinition de la méthode equals */
	public boolean equals(Object o){
		
		if(o instanceof Personnage){
			// Si le personnage a le meme nom et appartient au meme joueur alors c'est le meme vu qu'il n'y a pas
			// de doublons de personnage dans la meme equipe
			if(((Personnage) o).nom == this.nom && ((Personnage)o).numeroDAppartenanceJoueur == this.numeroDAppartenanceJoueur)
				return true;
		}
		return false;
			
	}
	
}
