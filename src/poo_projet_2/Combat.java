package poo_projet_2;

public class Combat extends Utilitaire
{
	//DECLARATION DES VARIABLES ET CONSTANTES
	public final static int minDamage = 100, maxDamage = 200;
	private int i;
	private int round;
	private int indexCombat;
	private Personnage competiteur1;
	private Personnage competiteur2;
	private String pullerClass;
	private String targetClass;
	private Personnage perdant;
	private Personnage vainqueur;

	//CONSTRUCTEUR
	public Combat(Personnage personnage1, Personnage personnage2, int indexCombat)
	{	
		//Initialisation des propiétés du combat
		this.round = 100;
		this.indexCombat = indexCombat;
		this.competiteur1 = personnage1;
		this.competiteur2 = personnage2;
		
		console("---------------------------------");
		console("");
		console("##### DEBUT DU COMBAT "+indexCombat+" #####");
		System.out.print(this.competiteur1.getNom() + " (" + this.competiteur1.getPv() + " PV)");
		System.out.print("   VS ");
		console("   "+ this.competiteur2.getNom() + " (" + this.competiteur2.getPv() + " PV)");
		console("");
		
		//Appel de la méthode pour lancer un combat
		lancementCombat(this.competiteur1, this.competiteur2);
	}

	//DESTRUCTEUR
	public void finalize()
	{
		console("");
		console("###### FIN DU COMBAT "+indexCombat+" #####");
		console("");
	}
	
	public Personnage getPerdant() 
	{
		return perdant;
	}
	
	public Personnage getVainqueur() 
	{
		return vainqueur;
	}
	
	//METHODE METIER
	public void lancementCombat(Personnage combattant1, Personnage combattant2)
	{
		//Répétition des affrontements jusqu'au dernier round ou jusqu'à la mort d'un combattant
		for(i = 1; i <= round; i++) 
		{	
			//Si les PV de l'un des combattants est à 0 => fin de la boucle combat
			if(combattant1.getPv() == 0 || combattant2.getPv() == 0)
			{
				//Si il s'agit du combattant 1
				if(combattant1.getPv() == 0) 
				{
					perdant = combattant1;
					vainqueur = combattant2;
					break;
				}
				else 
				{
					//Sinon il s'agit du combattant 2
					perdant = combattant2;
					vainqueur = combattant1;
					break;
				}
			}
			else 
			{
				//Sinon on appelle 2 fois la methode confrontation (attaque/riposte) en alternant le puller
				console("Affrontement "+i+" :");
				console("********************");
				
				//Si le numero de l'affrontement est impair
				if(i%2 == 1) 
				{
					confrontation(combattant1, combattant2);
					confrontation(combattant2, combattant1);
				}
				//Sinon pair
				else 
				{
					confrontation(combattant2, combattant1);
					confrontation(combattant1, combattant2);
				}
			}
			//console("Etat : "+combattant2.getNom() +" ("+combattant2.getPv()+"PV) - "+ combattant1.getNom() +" ("+combattant1.getPv()+"PV)");
			//combattant1.identite();
			//combattant2.identite();
			console("");
		}
	}
	
	public void confrontation(Personnage puller, Personnage target)
	{
		int damage = (int)getRandomInteger(minDamage,maxDamage);
		
		pullerClass = puller.getClass().getSimpleName();
		targetClass = target.getClass().getSimpleName();
		
		//On applique du damage supplementaire en fonction de la classe du puller
		damage += classAddDamage();
	
		//Si la valeur de damage est supérieure à la valeur de pv de la target
		if(damage >= target.getPv()) 
		{
			//alors on plafonne damage à la valeur de pv de la target
			damage = target.getPv();
		}
		
		/*
		//On diminue le damage si le puller est un guerrier
		if(targetClass.equals("Paladin") || targetClass.equals("Berserker")) 
		{
			guerrierBonus((Guerrier)target);
		}*/
		
		//On affiche le résultat de l'attaque et on met à jour les pv de la target
		System.out.println(puller.getNom() +" attaque "+ target.getNom() +" et lui inflige "+ damage +" points de dégats.");
		
		//Le puller gagne des PX et la target perd des PV
		target.refreshPv(-damage);
		puller.refreshPx();
		
		/*
		//On ajoute du PV à la target si c'est un mage
		if(targetClass.equals("Druide") || targetClass.equals("Alchimiste")) 
		{
			mageBonus((Mage)target);
		}*/
	}
	
	public int classAddDamage() 
	{
		int malus = 0;

		if(pullerClass.equals("Paladin")) 
		{
			malus = Guerrier.utiliserForce() + Paladin.utiliserCharisme();
		} 
		else if(pullerClass.equals("Berserker")) 
		{
			malus =  Guerrier.utiliserForce() + Berserker.utiliserFureur();
		}
		else if(pullerClass.equals("Druide")) 
		{
			malus = Mage.utiliserMana() + Druide.utiliserSagesse();
		}
		else if(pullerClass.equals("Alchimiste")) 
		{
			malus = Mage.utiliserMana() + Alchimiste.utiliserChimie();
		}
		return malus;
	}
	
	
	public void mageBonus(Mage target)
	{	
		target.utiliserSoin();
	}
	
	public void guerrierBonus(Guerrier target)
	{	
		target.utiliserProtection();
	}
	
}
