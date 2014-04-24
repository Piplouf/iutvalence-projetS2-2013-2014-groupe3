
public class Personnage extends Perso {
	
	private int vie;
	
	private String nom;
	
	private int vieMax;
	
	private int puissance;
	
	private Competence[] competences;
	
	private int capaciteDeDeplacement;
	
	public final static int NOMBRE_DE_COMPETENCES_PAR_DEFAUT = 4;
	
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
	
	public int obtenirVie(){
		return vie;
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
