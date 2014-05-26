package fr.projetS2_2013_2014_groupe3.jeu;

import java.util.ArrayList;


public class Sac{
	
	public ArrayList<ArrayList<Objet>> lotObjets;
	
	public Sac(){
		this.lotObjets = new ArrayList<ArrayList<Objet>>();
	}
	
	
	/**
	 * Ajoute un objet à notre sac
	 * @param objetAAjouter Objet que l'on souhaite ajouter à notre sac
	 * @param nombreObjets Nombre de fois que l'on veut rajouter l'objet
	 */
	public void ajouterObjet(Objet objetAAjouter,int nombreObjets){
		ArrayList<Objet> objets = new ArrayList<Objet>();
		int indexObjetExistant = 0;
		
		/*
		 * Si la pile est vide j'ajoute une collection du nombre d'objet que je souhaite
		 */
		if(this.lotObjets.isEmpty()){
			for(int i=0; i< nombreObjets;i++){
				objets.add(objetAAjouter);
			}
			this.lotObjets.add(objets);
		}
		/*
		 * Si la pile n'est pas vide je verifie que la collection de l'objet à rajouter n'existe pas, si elle existe je rajoute
		 * les objets à cette liste
		 */
		else{
			
			int i=0,j=0;
			
			while(i < this.lotObjets.size() && !(this.lotObjets.get(i).get(j).equals(objetAAjouter)))
			{
				j=0;
				while(j < this.lotObjets.get(i).size() && (this.lotObjets.get(i).get(j).equals(objetAAjouter))){
					j++;
				}
			
				if(j == this.lotObjets.get(i).size())
					j--;
				if(this.lotObjets.get(i).get(j) != objetAAjouter)
					i++;

			}
			
			if(i == this.lotObjets.size())
				i--;
			
			if(this.lotObjets.get(i).get(j).equals(objetAAjouter)){
				for(i=0; i< this.lotObjets.size();i++){
					if(this.lotObjets.get(i).get(j) == objetAAjouter)
						indexObjetExistant = i;
				}
				
				for(i=0; i< nombreObjets;i++){
					this.lotObjets.get(indexObjetExistant).add(objetAAjouter);
				}
				
			}
			else{
				for(i=0; i< nombreObjets;i++){
					objets.add(objetAAjouter);
				}
				
				this.lotObjets.add(objets);
			}
		}
		
		
	}
	
	public int obtenirIndexCollectionObjet(Objet objet){
		
int indexObjetExistant = 0;
		
		/*
		 * Si la pile est vide j'envoi 0
		 */
		if(this.lotObjets.isEmpty())
			return -1;
		/*
		 * Si la pile n'est pas vide je verifie que la collection de l'objet à rajouter n'existe pas, si elle existe je rajoute
		 * les objets à cette liste
		 */
		else{
			
			int i=0,j=0;
			
			while(i < this.lotObjets.size() && !(this.lotObjets.get(i).get(j).equals(objet)))
			{
				j=0;
				while(j < this.lotObjets.get(i).size() && (this.lotObjets.get(i).get(j).equals(objet))){
					j++;
				}
			
				if(j == this.lotObjets.get(i).size())
					j--;
				if(this.lotObjets.get(i).get(j) != objet)
					i++;

			}
			
			/*
			 * Si la collection existe déjà on retourne l'index de la collection
			 * sinon on renvoi -1 
			 */
			
			if(i == this.lotObjets.size())
				i--;
			
			if(this.lotObjets.get(i).get(j).equals(objet)){
				for(i=0; i< this.lotObjets.size();i++){
					if(this.lotObjets.get(i).get(j) == objet)
						indexObjetExistant = i;
				}
				return indexObjetExistant;
				
				
			}
			else{
				return -1;
			}
		}
	}	
	
	public String utiliserObjet(Objet objet, Personnage personnage){
	String utilisation;	
	if(this.verificationObjetExiste(objet)){	
		utilisation = objet.utiliserObjet(personnage);
		this.retirerObjets(objet);
		return  utilisation;
	}
	return("Impossible cet objet n'est plus disponible !");
	}
	
	/**
	 * Vérifie si l'objet existe dans le sac
	 * @param objet
	 * @return
	 */
	public boolean verificationObjetExiste(Objet objet){
		if(this.obtenirIndexCollectionObjet(objet) == -1)
			return false;
		return true;
	}
	
	private void retirerObjets(Objet objet){
		int indice = this.obtenirIndexCollectionObjet(objet);
		if(this.lotObjets.get(indice).size() == 1){
			this.lotObjets.get(indice).remove(objet);
			this.lotObjets.remove(indice);
		}
		else
			this.lotObjets.get(indice).remove(objet);
			
	}
	
	public String afficherContenuSac(){
		int compteur,j;
		String contenu = "Contenu du sac \n"
				+ "--------------\n";
		for(int i = 0; i < this.lotObjets.size();i++){
			compteur = 0;
			for(j = 0; j < lotObjets.get(i).size();j++){
				compteur++;
			}
			if(!(this.lotObjets.isEmpty()))
				contenu += compteur+"	"+lotObjets.get(i).get(j-1).getNom()+"\n";	
		}
		
		return contenu;
	}

}

