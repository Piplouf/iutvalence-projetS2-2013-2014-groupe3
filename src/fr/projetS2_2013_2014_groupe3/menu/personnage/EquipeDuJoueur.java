package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.AbstractButton;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Personnage;


/** JPanel contenant l'equipe du joueur */
public class EquipeDuJoueur extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashSet<PersonnageMenu> equipe;

	private MenuPersonnage ecranPerso;

	private JPanel persoJoueur;

	public EquipeDuJoueur(MenuPersonnage ecran) {

		this.ecranPerso = ecran;
		InitGUI();
	}

	/** Ajoute un perso a l'equipe si celle-ci n'est pas pleine*/
	public boolean ajouterPerso(PersonnageMenu perso) {

		for (int i = 0; i < 4; i++) {
			if (!this.persoJoueur.getComponent(i).isEnabled()) {
				((AbstractButton) this.persoJoueur.getComponent(i))
						.setIcon(perso.obtenirImage());
				((BoutonEquipe) this.persoJoueur.getComponent(i))
						.modifierPerso(perso.obtenirPerso());
				this.persoJoueur.getComponent(i).setEnabled(true);
				this.equipe.add(perso);

				if (i == 3)
					ecranPerso.obtenirBoutonValidation().setEnabled(true);

				return true;
			}
		}
		return false;
	}

	/** Retire un personnage de l'equipe*/
	public boolean retirerPerso(BoutonEquipe bouton) {

		supprimer(bouton.obtenirPerso(), this.equipe);
		this.refresh();
		ecranPerso.obtenirBoutonValidation().setEnabled(false);
		return true;
	}

	/** Initialise l'equipe du joueur vide*/
	public void InitGUI(){
		
		this.equipe = new HashSet<PersonnageMenu>();
		this.persoJoueur = new JPanel();

		for (int j = 0; j < 4; j++) {
			persoJoueur.add(new JPanel().add(new BoutonEquipe(
					new PersonnageMenu(), this.ecranPerso)));
		}
		this.add(persoJoueur);	
	}
	
	/** Refresh l'interface des qu'on ajoute un joueur*/
	private void refresh() {
		
		this.removeAll();
		this.persoJoueur = new JPanel();
		
		int nombreBoucle = 0;
		
		Iterator<PersonnageMenu> it = this.equipe.iterator();
		while(it.hasNext()){
			this.persoJoueur.add(new JPanel().add(new BoutonEquipe(it.next(),this.ecranPerso)));
			nombreBoucle++;
		}

		for (int j = nombreBoucle; j < 4; j++) {
			persoJoueur.add(new JPanel().add(new BoutonEquipe(
					new PersonnageMenu(), this.ecranPerso)));
		}

		this.add(persoJoueur);
		
	}

	/** Méthode retirant un joueur de l'equipe*/
	public boolean supprimer(PersonnageMenu perso, HashSet<PersonnageMenu> equipe) {

		for (Object o : equipe) {
			if (((PersonnageMenu) o).obtenirPerso().obtenirNom() == perso
					.obtenirPerso().obtenirNom()) {
				equipe.remove(o);
				return true;
			}
		}
		return false;
	}

	public Personnage[] obtenirPersonnageEquipe() {

		int i = 0;
		Personnage[] equipe = new Personnage[4];
		Iterator<PersonnageMenu> it = this.equipe.iterator();
		while (it.hasNext())
			equipe[i++] = it.next().obtenirPerso();
		return equipe;
	}

}
