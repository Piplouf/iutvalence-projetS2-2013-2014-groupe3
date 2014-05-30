package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

/** Interface du menu */
@SuppressWarnings("serial")
public class MenuPersonnage extends JPanel{
	
	private Fenetre fenetre;
	
	private Partie partie;
	
	private JLabel caracteristique;
	
	private SelecteurDePersonnage selecteur;
	
	private EquipeDuJoueur equipe;
	
	private BoutonValidationEquipe boutonValidation;
	
	private int numeroJoueur;
	
	public MenuPersonnage(Fenetre fen, Partie partie,int numero){
		
		this.fenetre = fen;
		this.partie = partie;
		this.numeroJoueur = numero;
		
		InitGUI();
	}
	
	/** Initialise l'interface graphique*/
	public void InitGUI(){
		
		JPanel fin = new JPanel();
		JPanel carac = new JPanel();
		JPanel boutonValider = new JPanel();
		JPanel posiDroit = new JPanel();
		JPanel vertical = new JPanel();
		
		this.boutonValidation = new BoutonValidationEquipe(this,this.numeroJoueur);
		
		vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));		
		posiDroit.setLayout(new GridLayout(2,1));
		
		JPanel gauche = new JPanel();
		JPanel droite = new JPanel();
		
		this.caracteristique = new JLabel("");
		this.caracteristique.setPreferredSize(new Dimension(200,170));
		this.caracteristique.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.caracteristique.setHorizontalAlignment(JLabel.CENTER);		
		this.boutonValidation.setPreferredSize(new Dimension(200,50));

		
		JSplitPane separation = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gauche,droite);
		separation.setDividerSize(10);
		separation.setDividerLocation(400);
		
		carac.add(this.caracteristique);
		boutonValider.add(this.boutonValidation);
		
		JLabel videDroit = new JLabel("");
		videDroit.setPreferredSize(new Dimension(100,100));
		
		JPanel videDroite = new JPanel();
		videDroite.add(videDroit);
		
		vertical.add(carac);
		vertical.add(videDroite);
		
		JLabel texteJoueur = new JLabel("Joueur "+Integer.toString(this.numeroJoueur + 1));
		texteJoueur.setFont(new Font("Arial", Font.BOLD,16));
		JPanel texteJou = new JPanel();
		texteJou.add(texteJoueur);
		
		gauche.add(texteJou);
		gauche.setLayout(new BoxLayout(gauche, BoxLayout.Y_AXIS));
		gauche.add(this.selecteur = new SelecteurDePersonnage(this));
		gauche.add(new JLabel("<html><br><br><br><br>"));
		gauche.add(this.equipe = new EquipeDuJoueur(this));
		
		posiDroit.add(vertical);
		posiDroit.add(boutonValider);
		
		droite.add(posiDroit);
		

		
		fin.add(gauche);
		//fin.add(separation);
		fin.add(droite);

		
		this.add(fin);
	}
	
	/** Ajouter a l'equipe un personnage*/
	public boolean ajouterJoueurEquipe(PersonnageMenu perso){
		return this.equipe.ajouterPerso(perso);
	}
	
	public void modifierNumeroJoueur(int num){
		this.numeroJoueur = num;
	}
	
	public Fenetre obtenirFenetre(){
		return this.fenetre;
	}
	
	/** Enleve a l'equipe un personnage*/
	public boolean retirerJoueurEquipe(BoutonEquipe bouton, PersonnageMenu perso){
		this.selecteur.reactiverBouton(perso);
		boolean ARetirer = this.equipe.retirerPerso(bouton);
		this.revalidate();
		return ARetirer;
	}
	
	public Partie obtenirPartie(){
		return this.partie;
	}
	
	public EquipeDuJoueur obtenirEquipeDuJoueur(){
		return this.equipe;
	}
	
	public void modifierCaracteristiques(String carac){
		this.caracteristique.setText(carac);
	}
	
	public BoutonValidationEquipe obtenirBoutonValidation(){
		return this.boutonValidation;
	}
	
	public int obtenirNumeroJoueur(){
		return this.numeroJoueur;
	}
}
