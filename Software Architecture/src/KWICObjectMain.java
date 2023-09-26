import java.io.*;

public class KWICObjectMain 
{
	public static void main(String[] args)
	{
		// An I/O exception may occur
		try
		{
			// Create a new KWICObject
			// Note: kwic.dat must be copied to your project folder, or use relative path, e.g. "C:/kwic.dat"
			KWICObject kwic = new KWICObject("C:\\Users\\rorym\\OneDrive - Edinburgh Napier University\\Uni\\Year 4\\Trimester 1\\Software Architecture\\Practicals\\Software Architecture\\src\\kwic.dat");
			// Display the list
			kwic.displayList();
		}
		catch (IOException ioe)
		{
			System.err.println("Error during file I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}
}
