package poo_projet_2;

public class Mage extends Personnage
{
	protected int minPv = 500, maxPv = 800;
	protected int minPm = 50, maxPm = 200;
	protected static int pm;
	
	public Mage()
	{	
		super();
		nom = "Un_Mage";
		pv = (int)getRandomInteger(minPv, maxPv);
		pm = (int)Utilitaire.getRandomInteger(minPm, maxPm);
		instances++;
	}
	
	public Mage(String nom)
	{
		super(nom);
		pv = (int)getRandomInteger(minPv, maxPv);
		pm = (int)Utilitaire.getRandomInteger(minPm, maxPm);
		instances++;
	}
	
	
	public Mage(String nom, int pv, int px, int mana)
	{
		super(nom, pv, px);
		pm = mana;
	}
	
	public static int getPm()
	{
		return pm;
	}
	
	public static void setPm(int mana)
	{
		pm = mana;
	}
	
	
	public static int utiliserMana()
	{
		return getPm();
	}
	
	public void utiliserSoin()
	{
		if(getPv() < 300)
		{
			setPv(getPv()+10);
			console(getNom()+" utilise un sort de soin et recupere 10 PV.");
		}
	}
	
	public void identite()
	{
		console("");
		console("Nom : " + nom );
		console("Vie : " + pv );
		console("Experience : " + px );
		console("Mana : " + pm );
		console("");
		console("------------------------------------");
	}

}