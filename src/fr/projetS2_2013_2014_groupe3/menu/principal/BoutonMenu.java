package fr.projetS2_2013_2014_groupe3.menu.principal;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.menu.personnage.MenuPersonnage;

public class BoutonMenu extends JButton {

	private Menu menu;

	public BoutonMenu(String nom, Menu men) {

		super(nom);
		this.menu = men;
		this.setPreferredSize(new Dimension(200, 50));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.obtenirFenetre().modifierPanneau(
						new MenuPersonnage(menu.obtenirFenetre(), menu
								.obtenirFenetre().obtenirPartie(), 0));
			}

		});
	}

}
