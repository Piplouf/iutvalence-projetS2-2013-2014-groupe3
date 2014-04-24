
public class Joueur {
	
	private Sac sac;
	
	private Personnage[] equipe;
	
	private int numero;
	
	private final static int NOMBRE_DE_PERSONNAGES_PAR_EQUIPE = 4;
	
	private static int nombreJoueurs = 1;
	
	public Joueur(){
		
		this.sac = new Sac();
		this.equipe = new Personnage[NOMBRE_DE_PERSONNAGES_PAR_EQUIPE];
		this.numero = nombreJoueurs++;
		
		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		
		for(int j =0; j < Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT; j++){
			compe[j] = new BouleDeFeu();
		}
		
		Personnage perso = new Personnage("Bob", 100, 10, 3, compe);
		
		for(int i = 0; i < NOMBRE_DE_PERSONNAGES_PAR_EQUIPE; i++){
			this.equipe[i] = perso;
		}
	}
	
	public Joueur(Personnage[] persoVoulus, int numero){
		this.sac = new Sac();
		this.equipe = new Personnage[NOMBRE_DE_PERSONNAGES_PAR_EQUIPE];
		this.numero = numero;
	}
	
	/**
	 * Renvoi l'attribut numero du joueur
	 */
	public int obtenirNumero(){
		return this.numero;
	}
	
	public Personnage[] obtenirPersonnageDUneEquipe(){
		return this.equipe;
	}
	
	public Personnage obtenirPersonnage(int numeroPerso){
		return this.equipe[numeroPerso];
	}
	
	public void ajouterJoueur(Personnage perso){
		
		int i = 0;
		while(this.equipe[i++] instanceof Personnage){
			
		}
		if(i == 4)
			return;
		this.equipe[i] = perso;
	}
	

}
