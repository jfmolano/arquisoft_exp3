package jose.adicionales;

public class StringAleatorio 
{
	public static void main(String[] args) {
		printChars();
		for (int i = 0; i < 30; i++) {
			String ram = getRandomLetterString(20, 30);
			System.out.println(getStringWhitDefinedLength(ram, 24) + "|" + ram);
		}
		
	}
	public static void printChars() {
		char a = 'a';
		for (a ='A'; a<('A'+126);)
		{
			System.out.println(a + " " + (a++));
			System.out.println(a);
		}
			
	}
	public static String getRandomStringNumber (int maxNum)
	{
		return ""+(int)(Math.random()*maxNum);

	}
	public static String getRandomLetterString(int minLength, int maxLength)
	{
		String resp = "";
		char actual = '_';
		int length =(int)( Math.random()*(maxLength-minLength)) + minLength; 
		for (int i = 0; i < length; i++) {
			actual =  (char) ('A' + (int)(Math.random()*('}'-'A')));
			resp+= actual;
		}
		return resp;
		
	}
	public static String getStringWhitDefinedLength(String string, int length)
	{
		String resp="";
		if (string.length() < length)
		{
			resp = string;
			for (int i = 0; i < length-string.length(); i++) {
				resp+=" ";
			}
		}
		else if (string.length() > length)
		{
			resp = string.substring(0, length);
		}
		else
		{
			resp = string;
		}
		return resp;
	}

}
