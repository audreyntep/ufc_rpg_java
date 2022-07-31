package poo_projet_2;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.ListIterator;

public class Competition extends Utilitaire
{
	ArrayList<Personnage> combattants;
	//LinkedList<Personnage> combattants;
	int i;
	
	//CONSTRUCTEUR
	public Competition(ArrayList<Personnage> list)
	//public Competition(LinkedList<Personnage> list)
	{
		combattants = list;
		try {
			//CREATION DE LA COMPETITION -> iteration jusqu'a ce qu'il ne reste qu'un ou aucun objet dans la collection
			console("");
			console("************************************");
			console("LANCEMENT DE LA COMPETITION");
			
			lancerCompetition();
			
		} 
		catch(Exception e)
		{
			console(""+e);
		}
		
	}
	
	//DESTRUCTEUR
	public void finalize()
	{
		console("");
		console("FIN DE LA COMPETITION");
		console("************************************");
	}
	
	//METHODE POUR LANCER UNE SERIE DE COMBATS
	public void lancerCompetition() 
	{
		//Tant que le nombre de combattants de la collection est superieur a 1
		while(combattants.size() > 1)
		{
			i++;
			lancerCombat();
		}
		if(combattants.size() == 1) 
		{
			console("Le grand Vainqueur est "+ combattants.get(0).getClass().getSimpleName() +" "+ combattants.get(0).getNom()+" !" );
			combattants.get(0).identite();
		}
		//Si le nombre de combattants de la collection est egal a 0
		else
		{
			console("Tout les combattants sont morts...");
		}
	}
	
	//METHODE POUR CREER UN COMBAT
	public void lancerCombat() 
	{	
		//Selection aleatoire de 2 combattants
		Personnage combattant1 = choisirCombattant();
		Personnage combattant2;
		do{
			combattant2 = choisirCombattant();
		}while(combattant1 == combattant2);
		
		//Instanciation d'un objet Combat
		Combat combat = new Combat(combattant1, combattant2, i);
		
		//On supprime le perdant de la collection et on affiche le vainqueur
		combattants.remove(combat.getPerdant());
		combat.getPerdant().finalize();
		console("Le vainqueur du combat est "+combat.getVainqueur().getNom()+".");
		
		//On verifie que les pv du vainqueur ne soient pas a 0
		if(combat.getVainqueur().getPv() == 0)
		{
			console("Mais "+combat.getVainqueur().getNom() +" ne survit pas a ses blessures...");
			combattants.remove(combat.getVainqueur());
			combat.getVainqueur().finalize();
		}
	
		combat.finalize();
	}
	
	
	//METHODE POUR SELECTIONNER UN COMBATTANT DANS LA LISTE
	public Personnage choisirCombattant() 
	{
		return combattants.get( (int)getRandomInteger(0, combattants.size()) );
	}
	
	//METHODE POUR AFFICHER LA LISTE DES COMBATTANTS
	public void afficherListCombattants()
	{
		//D�claration d'un it�rateur pour la ArrayList
		ListIterator<Personnage> li = combattants.listIterator();
		int j = 0;
		console("");
		console("Liste des combattants : ");
		//Affichage de chacun des objets de la collection par it�ration
		while(li.hasNext())
		{
			j++;
			Personnage personnage = (Personnage)li.next();
			console(j + " : " + personnage.getClass().getSimpleName() +" "+ personnage.getNom());
		}
	}
}
