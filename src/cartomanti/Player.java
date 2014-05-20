package cartomanti;
public class Player
{
	private String name;
	private double score;

	public Player(String name)
	{
		this.name = name;
	}

	public void setScore(double value)
	{
		this.score += value;

	}
	
	public void resetScore()
	{
		this.score = 0;
	}
	
	public double getScore()
	{
		return this.score;
	}

	public String getName()
	{
		return this.name;
	}

}