package poo_projet_2;

public class Personnage extends Utilitaire
{

	protected String nom;
	protected int pv;
	protected int minPv = 0, maxPv = 2000;
	protected int px;
	protected int minPx = 0, maxPx = 5000;
	protected final int fatal = 0;
	
	public Personnage()
	{
		nom = "Un_Personnage";
		pv = (int)getRandomInteger(minPv, maxPv);
		px = 0;
		instances++;
	}
	
	public Personnage(String nom)
	{
		this.nom = nom;
		pv = (int)getRandomInteger(minPv, maxPv);
		px = 0;
		instances++;
	}
	
	public Personnage(String nom, int pv, int px)
	{
		this.nom = nom;
		this.pv = pv;
		this.px = px;
		instances++;
	}

	
	public void finalize()
	{
		instances--;
		console(nom + " repose en paix.");
	}

	
	public String getNom()
	{
		return nom;
	}
	
	public int getPv()
	{
		return pv;
	}
	
	public int getPx()
	{
		return px;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public void setPv(int pv)
	{
		this.pv = pv;
	}
	
	public void setPx(int px)
	{
		this.px = px;
	}
	
	public void identite() 
	{
		console("");
	}
	
	//Mise à jour des PV
	public void refreshPv(int pv)
	{
		if(getPv() + pv > maxPv) 
		{
			setPv(maxPv);
		}
		else if(getPv() + pv < fatal) 
		{
			setPv(fatal);
		}
		else 
		{
			setPv(getPv() + pv);
		}
	}
	
	
	//Mise à jour des PX en fonction des PV
	public void refreshPx()
	{
		setPx( getPx() + ((getPv()*10)/100) );
	}
	
}