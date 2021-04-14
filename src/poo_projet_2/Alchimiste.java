package poo_projet_2;

public class Alchimiste extends Mage
{
	protected static int chimie;
	protected int minChi = 150, maxChi = 300;
	
	public Alchimiste()
	{
		super();
		nom = "Un_Alchimiste";
		chimie = (int)getRandomInteger(minChi, maxChi);
		console("");
		console("Un alchimiste crée");
		console("***************");
	}
	
	public Alchimiste(String nom)
	{
		super(nom);
		chimie = (int)getRandomInteger(minChi, maxChi);
		console("");
		console("Un alchimiste crée");
		console("***************");
	}
	
	public Alchimiste(String nom, int pv, int px, int pm, int chi)
	{
		super(nom, pv, px, pm);
		chimie = chi;
		console("");
		console("Un alchimiste crée");
		console("***************");
	}
	
	public static int getChimie()
	{
		return chimie;
	}
	
	public static void setChimie(int chi)
	{
		chimie = chi;
	}
	
	public static int utiliserChimie() 
	{
		setPm(getPm()+10);
		return getChimie();
	}
	
	public void identite()
	{
		console("Nom : " + nom );
		console("Vie : " + pv );
		console("Expérience : " + px );
		console("Mana : " + pm );
		console("Chimie : " + chimie );
		console("");
		console("------------------------------------");
	}
	
}
