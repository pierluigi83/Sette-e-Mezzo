package cartomanti;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Classifica 
{
	private static String file = "Classifica.txt";
	private static Charset characterSet = Charset.defaultCharset();
	private static Path path = Paths.get(file);
	private static List<String> lines;
	
	private static void read() throws IOException
	{
		lines =
		Files.readAllLines(path, characterSet);
	}
	
	private static int newItem(String p)
	{
		int r = 0;
		for (int i=0; i < lines.size();i++)
		{
			if (p.equals(lines.get(i).toString()))
			{
				return i;
			}
		}
		return r;
	}
	
	public static void updateList(String p)
	{
		if (newItem(p) == 0)
		{
			lines.add(p);
			lines.add("1");
		}
		else
		{
			int i = newItem(p);
			lines.set(i+1, Integer.toString(Integer.parseInt(lines.get(i+1).toString()) + 1));
		}
	}
	
	public static void write() throws IOException
	{
		try (BufferedWriter writer = Files.newBufferedWriter(path,characterSet))
		{
			for (int i=0; i < lines.size(); i++)
			{
				writer.write(lines.get(i)+"");
				writer.newLine();
			}
		}
	}
	
	public static void updateClassify(String p) throws IOException
	{
		read();
		updateList(p);
		write();
		
	}
	

}
