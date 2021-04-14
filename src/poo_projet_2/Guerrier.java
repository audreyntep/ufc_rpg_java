package poo_projet_2;

public class Guerrier extends Personnage
{
	protected int minPv = 900, maxPv = 1500;
	protected int minFo = 50, maxFo = 200;
	protected static int force;
	
	public Guerrier()
	{
		super();
		nom = "Un_Guerrier";
		pv = (int)getRandomInteger(minPv, maxPv);
		force = (int)getRandomInteger(minFo, maxFo);
	}
	
	public Guerrier(String nom)
	{
		super(nom);
		pv = (int)getRandomInteger(minPv, maxPv);
		force = (int)getRandomInteger(minFo, maxFo);
	}
	
	public Guerrier(String nom, int pv, int px, int fo)
	{
		super(nom, pv, px);
		force = fo;
	}
	
	public static int getForce()
	{
		return force;
	}
	
	public static void setForce(int fo)
	{
		force = fo;
	}
	
	public static int utiliserForce()
	{
		return getForce();
	}
	
	public void utiliserProtection()
	{
		if(getPv() < 300)
		{
			setPv(getPv()+10);
			console(getNom()+" utilise son bouclier et récupère 10 PV.");
		}
	}
	
	public void identite()
	{
		console("");
		console("Nom : " + nom );
		console("Vie : " + pv );
		console("Expérience : " + px );
		console("Force : " + force );
		console("");
		console("------------------------------------");
	}
	

}
