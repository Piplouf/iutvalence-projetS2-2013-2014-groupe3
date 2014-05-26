package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.Component;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Personnage;

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

	public boolean retirerPerso(BoutonEquipe bouton) {

		supprimer(bouton.obtenirPerso(), this.equipe);
		this.refresh();
		ecranPerso.obtenirBoutonValidation().setEnabled(false);
		return true;
	}

	public void InitGUI(){
		
		this.equipe = new HashSet<PersonnageMenu>();
		this.persoJoueur = new JPanel();

		for (int j = 0; j < 4; j++) {
			persoJoueur.add(new JPanel().add(new BoutonEquipe(
					new PersonnageMenu(), this.ecranPerso)));
		}
		this.add(persoJoueur);	
	}
	
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
