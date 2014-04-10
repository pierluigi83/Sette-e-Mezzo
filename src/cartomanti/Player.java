package cartomanti;
public class Player
{
	private String name;
	private boolean turn;
	private int[] tokencards;
	private double score;

	public Player(String name)
	{
		this.name = name;
	}

	public void getCard(int i)
	{
		tokencards[i] = i; 
	}

	public int[] showCards()
	{
		return tokencards;
	}

	public void setScore(int value)
	{
		this.score += value;

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