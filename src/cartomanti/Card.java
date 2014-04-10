package cartomanti;
public class Card
{
	private int number;
	private String seed;
	private double value;
	private boolean discovered;
	private String name;
	
	public Card()
	{
		
	}

	public Card(int number,String seed)
	{
		this.number = number;
		this.seed = seed;
		this.setValue();
		this.discovered = false;
	}
	
	public void setNumber(int number)
	{
		this.number = number;
	}
	
	public void setSeed(String seed)
	{
		this.seed = seed;
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
	
	public void discover()
	{
		this.discovered = true;
	}

	public void print()
	{
		
			System.out.println(" ************ ");
			System.out.println(" * " + " * ");
			System.out.println(" * " + " * ");
			System.out.println(" * " + name + " * ");
			System.out.println(" * " + " DI " + " * ");
			System.out.println(" * " + seed + " * ");
			System.out.println(" * " + " " + number + " * ");
			System.out.println(" * " + " * ");
			System.out.println(" * " + " * ");
			System.out.print(" ************ ");
			
	}

}
