package poo_projet_2;

public class Berserker extends Guerrier
{
	protected static int fureur;
	protected int minFu = 50, maxFu = 200;
	
	public Berserker()
	{
		super();
		nom = "Un_Berserkerr";
		fureur = (int)getRandomInteger(minFu, maxFu);
		console("");
		console("Un berserker cree");
		console("***************");
	}
	
	public Berserker(String nom)
	{
		super(nom);
		fureur = (int)getRandomInteger(minFu, maxFu);
		console("");
		console("Un berserker cree");
		console("***************");
	}
	
	public Berserker(String nom, int pv, int px, int fo, int fu)
	{
		super(nom, pv, px, fo);
		fureur = fu;
		console("");
		console("Un berserker cree");
		console("***************");
	}
	
	public static int getFureur()
	{
		return fureur;
	}
	
	public static void setFureur(int fu)
	{
		fureur = fu;
	}
	
	public static int utiliserFureur()
	{
		setForce(getForce()+10);
		return getFureur();
	}
	
	public void identite()
	{
		console("Nom : " + nom );
		console("Vie : " + pv );
		console("Experience : " + px );
		console("Force : " + force );
		console("Fureur : " + fureur );
		console("");
		console("------------------------------------");
	}

	
}
