package cartomanti;
public class Card
{
	private int number;
	private String seed;
	private double value;
	private boolean discovered;
	private String name;
		
	public Card(int number,String seed,String name)
	{
		this.number = number;
		this.seed = seed;
		this.name = name;
		this.setValue();
		this.discovered = false;
	}
			
	private void setValue()
	{
		if (this.number < 8)
		{
			this.value = this.number;
		}
		else
		{
			this.value = 0.5;
		}
	}

	public double getValue()
	{
		return this.value;
	}

	public boolean checkMatta()
	{
		if (this.number == 10 && this.seed == "denari")
		{
			return true;
		}
		return false;
	}
	
	public String getSeed()
	{
		return seed;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void discover() //può servire quando giocano più players
	{
		this.discovered = true;
	}
	
	public void stampa(int lun,String var)
	{
		int spacesleft = (14 - lun)/2;
		int spacesright = (14- lun - spacesleft);
		for (int i = 0; i< spacesleft;i++)
		{
			System.out.print(" ");
			
		}
		System.out.print(var);
		for (int i=0; i<spacesright;i++)
		{
			System.out.println(" ");
		}
	}
	

	public void print()
	{
		System.out.println("**************");
		System.out.printf("*%10s  *\n"," ");
		System.out.printf("*%10s  *\n"," ");
		System.out.printf("*%12s*\n",StringUtils.getCenteredString(12, name));
		System.out.printf("*%10s  *\n","DI   ");
		System.out.printf("*%12s*\n",StringUtils.getCenteredString(12, seed));
		System.out.printf("*%12s*\n",StringUtils.getCenteredString(12, number+""));
		System.out.printf("*%10s  *\n"," ");
		System.out.printf("*%10s  *\n"," ");
		System.out.println("**************");
		
		
	}
	

	

}
