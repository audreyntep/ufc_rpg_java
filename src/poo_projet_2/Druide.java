package poo_projet_2;

public class Druide extends Mage
{
	protected static int sagesse;
	protected int minSa = 150, maxSa = 300;
	
	public Druide()
	{
		super();
		nom = "Un_Druide";
		sagesse = (int)getRandomInteger(minSa, maxSa);
		console("");
		console("Un druide crée");
		console("***************");
	}
	
	public Druide(String nom)
	{
		super(nom);
		sagesse = (int)getRandomInteger(minSa, maxSa);
		console("");
		console("Un druide crée");
		console("***************");
	}
	
	public Druide(String nom, int pv, int px, int pm, int sa)
	{
		super(nom, pv, px, pm);
		sagesse = sa;
		console("");
		console("Un druide crée");
		console("***************");
	}

	public static int getSagesse()
	{
		return sagesse;
	}
	
	public static void setSagesse(int sa)
	{
		sagesse = sa;
	}

	public static int utiliserSagesse()
	{
		setPm(getPm()+10);
		return getSagesse();
	}
	
	public void identite()
	{
		console("Nom : " + nom );
		console("Vie : " + pv );
		console("Expérience : " + px );
		console("Mana : " + pm );
		console("Sagesse : " + sagesse );
		console("");
		console("------------------------------------");
	}

}
