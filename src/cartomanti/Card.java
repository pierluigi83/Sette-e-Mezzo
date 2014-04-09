package cartomanti;

public class Card
{
	private int number;
	private double value;
	private String name;
	private String seed;
	private boolean covered;
	private int id;
	public Card(int id,int number,String seed)
	{
		this.id = id;
		this.number =number;
		this.seed = seed;
		this.covered = true;
		
	}
	public void setValue()
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
	public boolean checkMatta()
	{
		if (this.number == 10 && this.seed == "denari")
		{
			return true;
		}
		return false;
	}
	public void uncover()
	{
		this.covered = false;
	}
	public void print()
	{
		
	}
	
	
	
	

}
