package cartomanti;
import java.io.IOException;
import java.util.*;

public class Game
{
	final int NUMBER_OF_ROWS = 52;
	public final int ROW_OFFSET = 14;
	private String[] row = new String[NUMBER_OF_ROWS];
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
	
	public void  initializeRows()
	{
		for(int i=0;i<NUMBER_OF_ROWS;i++)
		{
			row[i] = "";
		}
		
	}
	
	public void initializeTitle()
	{
		row[0] = putSpaces(60) + "*****************************";
		row[1] = putSpaces(60) + "*                           *";
		row[2] = putSpaces(60) + "* GIOCO DEL SETTE E MEZZO   *";
		row[3] = putSpaces(60) + "*                           *";
		row[4] = putSpaces(60) + "*****************************";
	}
	
	public void printMaze()
	{
		row[12] = putSpaces(60) + "         **************         ";
		row[13] = putSpaces(60) + "         *            *         ";
		row[14] = putSpaces(60) + "         *            *         ";
		row[15] = putSpaces(60) + "         *            *         ";
		row[16] = putSpaces(60) + "         *   MAZE     *         ";
		row[17] = putSpaces(60) + "         *            *         ";
		row[18] = putSpaces(60) + "         *            *         ";
		row[19] = putSpaces(60) + "         *            *         ";
		row[20] = putSpaces(60) + "         *            *         ";
		row[21] = putSpaces(60) + "         **************         "; 
	}
	
	public void printNumMaze(int n)
	{
		
		row[22] = putSpaces(61) + "              " + n;
	}
	
	public String putSpaces(int spaces )
	{
		String r = "";
		for (int i=0; i<spaces;i++)
		{
			r+=" ";
			
		}
		return r;
	}
	
	public String fS(String name)
	{
		String r="";
		int spaceleft = (12 - name.length())/2;
		int spaceright = 12 - name.length() - spaceleft;
		r = putSpaces(spaceleft) + name + putSpaces(spaceright);
		return r;
		
	}
	public void printCard(String name, String seed, int number,int offset)
	{
		
		
		row[27+offset] += "         **************";
		row[28+offset] += "         *            *";
		row[29+offset] += "         *"+fS(name)+"*";
		row[30+offset] += "         *            *";
		row[31+offset] += "         *     di     *";
		row[32+offset] += "         *            *";
		row[33+offset] += "         *"+fS(seed)+"*";
		row[34+offset] += "         *            *";
	  //row[35+offset] += "         *            *";
		row[36+offset] += "         **************";
		if ((seed == "denari") && (number == 10))
		{
			row[35+offset] += "         *    MATTA   *";
		}
		else
		{
			row[35+offset] += "         *            *";
		}
		
	}
	public void printPlayer(String name)
	{
		row[23] = putSpaces(60) + "           GIOCATORE: " + name;
	}
	
	public void printPoint(double num)
	{
		row[25] = putSpaces(60) + "           PUNTEGGIO: " + num;
	}
	
	public void printComputer()
	{
		row[37] = putSpaces(60) + "           COMPUTER: Mazziere";
	}
	
	public void printPointComputer(double num)
	{
		row[39] = putSpaces(60) + "           PUNTEGGIO:" + num;
	}
	
	public void printBoard()
	{
		System.out.print("\u001b[2J");
		System.out.flush();
		for(int i=0;i<NUMBER_OF_ROWS;i++)
		{
			System.out.println(row[i]);
		}
		
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
  		if(score == Math.floor(score)) // è intero
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

  	public void whoWins(double a,double b,String name) throws IOException
  	{
  		if (a > b)
		{
			System.out.println(name + " hai vinto! con " + a + " contro " + b);
			Classifica.updateClassify(name);
			System.out.println("aggiornamento eseguito");
		}
		else 
		{
			System.out.println(name + " hai perso! con " + a + " contro " + b);
		}
  	}

	public static void main(String[] args) throws Exception
	{
		Game g = new Game();
		Player m = new Player("Mazziere");
		Card[] c;
		c = new Card[40];
		String[] name =  {"null","asso","due","tre","quattro","cinque","sei","sette","donna","cavallo","re"};
		// inizializza carte
		for(int i = 0; i < 40; i++)
		{
			if (i < 10)
			{
				c[i] = new Card(i+1,"spade",name[i+1]);
			}
			else if (i < 20)
			{
				c[i] = new Card(i-10+1,"denari",name[i-10+1]);
			}
			else if (i<30)
			{
				c[i] = new Card(i-20+1,"coppe",name[i-20+1]);
			}
			else if (i<40)
			{
				c[i] = new Card(i-30+1,"bastoni",name[i-30+1]);
			}
		}
		// mescola carte
		int[] maze;
		maze = new int[40];
		for (int i= 0; i<40; i++)
		{
			maze[i] = i;
		}
		maze = g.shakeMaze(maze);
		//inizializzazione grafica
		Scanner input = new Scanner(System.in);
		g.initializeRows();
		g.initializeTitle();
		g.printMaze();
		g.printNumMaze(40);
		g.printBoard();
		System.out.println("Gioco del Sette e Mezzo, premi un tasto per iniziare");
		// stampa mazzo mazziere  a sinistra e giocatore a destra
		//aspetta un tasto 
		System.in.read();
		g.printBoard();
		System.out.println("Inserisci il tuo nome");
		String s = input.next();
		g.printPlayer(s);
		g.printBoard();
		Player p = new Player(s);
		// dai carta al giocatore
		//ciclo while
		boolean gioca = true;
		while(gioca)
		{
			maze = g.shakeMaze(maze);
			g.initializeRows();
			g.initializeTitle();
			g.printMaze();
			g.printNumMaze(40);
			g.printPlayer(s);
			g.printBoard();
			p.resetScore();
			m.resetScore();
			boolean hasmatta = false;
			boolean hasmattac = false;
			double realscore = 0;
			double realscorec = 0;
			double matta = 0;
			double mattac = 0;
			int i = 0;
			//p.getCard(i);
			g.printCard(c[maze[i]].getName(),c[maze[i]].getSeed(),c[maze[i]].getNumber(),0);
			p.setScore(c[maze[i]].getValue());
			if (c[maze[i]].checkMatta())
			{
				hasmatta = true;
				g.modifyScore(c[maze[i]].getValue());
			}
			g.printNumMaze(40-1-i);
			g.printPoint(p.getScore());
			g.printBoard();
			//c[maze[i]].print();
			System.out.println("Punteggio:" + p.getScore());
			boolean give = true;
			i++;
			// dai altre carte al giocatore
			while(give)
			{
				System.out.println("Vuoi un'altra carta? Se si premi 1, se no premi 0");
				if (input.nextInt() == 1) //aggiustare
				{
					//p.getCard(i);
					g.printCard(c[maze[i]].getName(),c[maze[i]].getSeed(),c[maze[i]].getNumber(),0);
					g.printNumMaze(40-1-i);
					//c[maze[i]].print();
					p.setScore(c[maze[i]].getValue());
					if ((hasmatta) || (c[maze[i]].checkMatta()))
					{
						realscore = p.getScore() - matta;
						p.resetScore();
						p.setScore(realscore);
						if (hasmatta == false)
						{
							hasmatta = true;
						}
						if (realscore < 7.5)
						{
							matta = g.modifyScore(p.getScore());
							p.setScore(g.modifyScore(p.getScore()));
						}
					}
					g.printPoint(p.getScore());
					g.printBoard();
					System.out.println("Punteggio:" + p.getScore());
					if (p.getScore() > 7.5)
					{
						System.out.println(p.getScore() + " Hai perso!");
						give = false;
					}
				}
				else
				{
					give = false;
				}
				i++;
			}
			// dai carte al mazziere
			if (p.getScore() <= 7.5)
			{				
				int a = i; // primo indice carte prese dal mazziere
				give = true;
				g.printComputer();
				System.out.println("Carte mazziere:");
				while(give)
				{
					//m.getCard(i);
					g.printCard(c[maze[i]].getName(),c[maze[i]].getSeed(),c[maze[i]].getNumber(),g.ROW_OFFSET);
					m.setScore(c[maze[i]].getValue());
					if ((hasmattac) || (c[maze[i]].checkMatta()))
					{
						realscorec = p.getScore() - mattac;
						p.resetScore();
						p.setScore(realscorec);
						if (hasmattac == false)
						{
							hasmattac = true;
						}
						if (realscorec < 7.5)
						{
							mattac = g.modifyScore(p.getScore());
							p.setScore(g.modifyScore(p.getScore()));
						}
					}
					//c[maze[i]].print();
					g.printNumMaze(40-1-i);
					g.printPointComputer(m.getScore());
					g.printBoard();
					if (m.getScore() > 7.5)
					{
						System.out.println(m.getScore() + " Il mazziere ha sballato, hai vinto!");
						Classifica.updateClassify(p.getName());
						System.out.println("aggiornamento eseguito");
						give = false;
					}
					double treshold = 7.5 - m.getScore();
					if ((g.chances(i,c,maze,treshold) > 0.3) || (m.getScore() < p.getScore()))//-c[maze[0]].getValue()
					{
						give = true;
					}
					else
					{
						give = false;
					}
					i++;
				}
			}
			if ((p.getScore() <= 7.5) && (m.getScore() <= 7.5))
			{
			// determina vincitore
			g.whoWins(p.getScore(),m.getScore(),p.getName());
			}
			System.out.println("Premi 1 per rigiocare, 0 per uscire");
			if (input.nextInt() == 0)
			{
				gioca = false;
			}
		}
		input.close(); //chiudi scanner
		//esci
	}
}