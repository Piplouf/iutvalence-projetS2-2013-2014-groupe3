
public class Joueur {
	
	private Sac sac;
	
	private Personnage[] equipe;
	
	private int numero;
	
	private final static int NOMBRE_DE_PERSONNAGES_PAR_EQUIPE = 4;
	
	public Joueur(Personnage[] persoVoulus, int numero){
		this.sac = new Sac();
		this.equipe = persoVoulus;
		this.numero = numero;
	}
	

}
