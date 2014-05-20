package cartomanti;

public class StringUtils {
	
	public static String getCenteredString(int space, String str) {
		String result = "";
		
		int leftSpace = (space - str.length()) / 2;
		int rightSpace = (space - str.length()) - leftSpace;
		
		for (int i =0; i < leftSpace; i++) {
			result += " ";
			
		}
		result += str;
		
		for (int i = 0; i <rightSpace; i++) {
			result += " ";
		}
	return result;
	}
	
}
