package poo_projet_2;

public class Paladin extends Guerrier
{
	protected static int charisme;
	protected int minCha = 50, maxCha = 200;
	
	public Paladin()
	{
		super();
		nom = "Un_Paladin";
		charisme = (int)getRandomInteger(minCha, maxCha);
		console("");
		console("Un paladin cree");
		console("***************");
	}
	
	public Paladin(String nom)
	{
		super(nom);
		charisme = (int)getRandomInteger(minCha, maxCha);
		console("");
		console("Un paladin cree");
		console("***************");
	}
	
	public Paladin(String nom, int pv, int px, int fo, int cha)
	{
		super(nom, pv, px, fo);
		charisme = cha;
		console("");
		console("Un paladin cree");
		console("***************");
	}
	
	public static int getCharisme()
	{
		return charisme;
	}
	
	public static void setCharisme(int cha)
	{
		charisme = cha;
	}
	
	public static int utiliserCharisme()
	{
		setForce(getForce()+10);
		return getCharisme();
	}
	
	public void identite()
	{
		console("Nom : " + nom );
		console("Vie : " + pv );
		console("Experience : " + px );
		console("Force : " + force );
		console("Charisme : " + charisme );
		console("");
		console("------------------------------------");
	}

}
