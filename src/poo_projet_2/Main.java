package poo_projet_2;

import java.util.ArrayList;
//import java.util.LinkedList;

public class Main extends Utilitaire
{
	static ArrayList<Personnage> personnages = new ArrayList<Personnage>();
	static int i;
	//static LinkedList<Personnage> personnages = new LinkedList<Personnage>();
	
	public static void main(String[] args)
	{
	
		long start = System.currentTimeMillis();;
	    
		console("*************************");
		console("* Projet Java en P.O.O. *");
		console("*************************");
		console("");

		console("");
		console("    WELCOME TO THE ULTMATE FIGHTING COMICS GAME ");
		console("       ___   ___       ________      ________   ");
		console("      /  /  /  /      /  _____/     /  _____/   ");
		console("     /  /  /  /      /  /____      /  /         ");
		console("    /  /  /  /      /  _____/     /  /          ");
		console("   /  /__/  /  __  /  /    __    /  /____   __");
		console("  /________/  /_/ /__/    /_/   /_______/  /_/");
		console("");
		
		//CREATION DES PERSONNAGES -> 1.instanciation, 2.affichage, 3.ajout a la collection
		
		Druide panoramix = new Druide("Panoramix");
		panoramix.identite();
		personnages.add(panoramix);
		
		Alchimiste edward = new Alchimiste("Edward");
		edward.identite();
		personnages.add(edward);

		Berserker odin = new Berserker("Odin");
		odin.identite();
		personnages.add(odin);
		
		Paladin thanos = new Paladin("Thanos");
		thanos.identite();
		personnages.add(thanos);
		
		
		//CREATION D'UNE COMPETITION
		Competition competition = new Competition(personnages);
		competition.finalize();
		

	    long end = System.currentTimeMillis();;
	    System.out.println((end - start) + " ms");
	}

}