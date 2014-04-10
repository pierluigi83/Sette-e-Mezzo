package cartomanti;
import java.util.*;

public class Game
{
	public int[] shakeMaze(int[] ar)
  	{
    	Random rnd = new Random();
    	for (int i = ar.length - 1; i > 0; i--)
    	{
      		int index = rnd.nextInt(i + 1);
     		 // Simple swap
     		 int a = ar[index];
     		 ar[index] = ar[i];
     		 ar[i] = a;
    	}
    	return ar;
  	}

  	private int luckycards(Card[] c, double treshold)
  	{
  		int goodcards = 0;
  		for (int i =0; i < 40; i++)
  		{
  			if (c[i].getValue() <= treshold)
  			{
  				goodcards += 1;
  			}
  		}
  		return goodcards;
  	}

  	public double modifyScore(double score)
  	{
  		if(score) // è intero
		{
		//score = 7.5;
			return 7.5 - score;
		}
		else
		{
			if(score != 7.5)
			{
				//score = 7;
				return 7 - score;
			}
			else
			{
				return 0;
			}
		}
  	}

  	private int luckycardstable(int cardstable, Card[] c, int[] maze, double treshold)
  	{
  		int goodcardstable = 0;
  		for (int i=0; i< cardstable; i++)
  		{
  			if (c[maze[i]].getValue() <= treshold)
  			{
  				goodcardstable += 1;
  			}
  		}
  		return goodcardstable;
  	}

  	public double chances(int cardstable,Card[] c,int[] maze,double treshold)
  	{
  		int goodcardsmaze = luckycards(c,treshold) - luckycardstable(cardstable,c,maze,treshold);
  		return goodcardsmaze / (40-cardstable);
  	}

  	public boolean checkMatta(int startindex,int stopindex,Card[] c, int[] maze)
  	{
  		for (int i=startindex; i< stopindex; i++)
  		{
  			if (c[maze[i]].checkMatta())
  			{
  				return true;
  			}	
  		}
  		return false;
  	}

  	public void whoWins(double a,double b,String name)
  	{
  		if (a > b)
		{
			System.out.println(name + " hai vinto! con " + a + " contro " + b);
		}
		else 
		{
			System.out.println(name + " hai perso! con " + a + " contro " + b);
		}
  	}

	public static void main(String[] args)
	{
		Player p = new Player("Pierluigi");
		// inizializza carte
		for(int i = 0; i < 40; i++)
		{
			if (i < 10)
			{
			Card c[i] = new Card(i,"spade")
			}
			else if (i < 20)
			{
				Card c[i] = new Card(i,"denari")
			}
			else if (i<30)
			{
				Card c[i] = new Card(i,"coppe")
			}
			else if (i<40)
			{
				Card c[i] = new Card(i,"bastoni")
			}
		}
		// mescola carte
		int[] maze;
		for (int i= 0; i<40; i++)
		{
			maze[i] = i;
		}
		maze = shakeMaze(maze);
		// dai carta al giocatore
		p.getCard(0);
		p.setScore(c[maze[0]].getValue());
		boolean give = true;
		// dai altre carte al giocatore
		while(give)
		{
			system.out.println("Vuoi un'altra carta?");
			scanner();
			if (scanner == "si")
			{
				p.getCard(i);
				p.setScore(c[maze[i]].getValue());
				if (p.getScore() > 7.5)
				{
					System.out.println("Hai perso!");
					return;
				}
			}
			else
			{
				give = false;
				if (checkMatta(0,i,c,maze))
				{
					p.setScore(modifyScore(p.getScore())); // è intero)
				}
			}
			i++;
		}
		// dai carte al mazziere
		int a = i; // primo indice carte prese dal mazziere
		give = true;
		while(give)
		{
			m.getCard(i);
			m.setScore(c[maze[i]].getValue());
			if (checkMatta(a,i,c,maze))
			{
				p.setScore(modifyScore(p.getScore()); // è intero)
			}
			
			if (m.getScore() > 7.5)
			{
				println("Il mazziere ha sballato, hai vinto!");
				return;
			}
			double treshold = 7.5 - m.getScore();
			if (chances(i,c,maze,treshold) > 0.5)
			{
				give = true;
			}
			else
			{
				give = false;
			}
			i++;
		}
		// determina vincitore
		whoWins(p.getScore(),m.getScore(),p.getName());
	}
}