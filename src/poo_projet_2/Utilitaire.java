package poo_projet_2;

public abstract class Utilitaire 
{
	protected static byte instances = 0;
	
	public static byte getInstances()
	{
		return instances;
	}
	
	public static double getRandomInteger(int min, int max) 
	{
	    return Math.floor(Math.random() * (Math.floor(max) - Math.ceil(min))) + Math.ceil(min);
	} 
	
	public static void console(String element) 
	{
		System.out.println(element);
	}


}
