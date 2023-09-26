import java.io.*;
import java.util.*;

public class KWICMain 
{
	/**
	 * The main KWIC program
	 * 
	 * @param args Any arguments passed in from the command line
	 */
	public static void main(String[] args)
	{
		// First declare the required parameters for the program.
		// We have the input file, a temporary string read from the file,
		// and the list of shifted lines.
		BufferedReader input_file;
		String line;
		ArrayList<String> kwicList = new ArrayList<String>();
		
		// We are doing I/O operations, so we must ensure exceptions are 
		// handled.
		try
		{
			// First open the file
			// Note: kwic.dat must be copied to your project folder, or use relative path, e.g. "C:/kwic.dat"
			input_file = openFile("C:\\Users\\rorym\\OneDrive - Edinburgh Napier University\\Uni\\Year 4\\Trimester 1\\Software Architecture\\Practicals\\Software Architecture\\src\\kwic.dat");
			
			// Now we want to read from the file until no lines are left
			while (input_file.ready())
			{
				// Read in the next line
				line = readLine(input_file);
				
				// Shift the line
				shiftLine(line, kwicList);
			}
			
			// All lines have been read in from the file.  Now sort the list.
			// We cheat and use Java's built in sort algorithm
			Collections.sort(kwicList);
			
			// Display the final, sorted list
			displayList(kwicList);
		}
		catch (IOException ioe)
		{
			// Oh-oh.  We have a problem.  Display exception and exit.
			System.err.println("Error during file I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}
	
	/**
	 * Opens the file
	 * 
	 * @param file_name The name of the file to open
	 * @return A BufferedReader which we can use to read the lines in the file from
	 * @throws IOException Thrown if something goes wrong during the I/O operations
	 */
	static BufferedReader openFile(String file_name) throws IOException
	{
		// Open the file with the given file name
		FileReader file = new FileReader(file_name);
		// Create a BufferedReader for the file, and return it
		return new BufferedReader(file);
	}
	
	/**
	 * Reads the next line from the file
	 * 
	 * @param input_file File to read the line from
	 * @return The string read from the file
	 * @throws IOException Thrown if something goes wrong during the I/O operations
	 */
	static String readLine(BufferedReader input_file) throws IOException
	{
		// Read the next line in
		String line = input_file.readLine();
		// Display the read line on the screen
		System.out.println(line);
		// Return the read line
		return line;
	}
	
	/**
	 * Shifts the line and adds it to the list
	 * 
	 * @param line The line to shift
	 * @param kwicList The list of shifted lines
	 */
	static void shiftLine(String line, ArrayList<String> kwicList)
	{
		// Use the StringTokenizer to turn the read line into 
		// its individual elements.
		StringTokenizer tokenizer = new StringTokenizer(line, " .,;:()");
		
		// Create an array to store all the elements in.  The 
		// size of the array is the number of tokens in the tokenizer.
		String[] tokens = new String[tokenizer.countTokens()];
		
		// Now read the tokens into the array
		for (int i = 0; tokenizer.hasMoreTokens(); i++)
			tokens[i] = tokenizer.nextToken();
		
		// Time to shift the line.  We do this as many times as there are 
		// tokens, as this is the number of combinations of shifted words.
		//
		// Example:
		// the quick brown fox jumped over the lazy dog
		// 
		// This becomes:
		// the quick brown fox jumped over the lazy dog
		// quick brown fox jumped over the lazy dog the
		// brown fox jumped over the lazy dog the quick
		// fox jumped over the lazy dog the quick brown
		// etc.
		for (int tokenCount = 0; tokenCount < tokens.length; tokenCount++)
		{
			// This is the string we will store the shifted line in
			String temp = "";
			
			// Start the shifted line from 0, then 1, 2 ...
			int index = tokenCount;
			
			// Now ensure we use all the tokens
			for (int i = 0; i < tokens.length; i++)
			{
				// The index will eventually become greater than 
				// the size of the token array.  For example, consider:
				//
				// the quick brown fox jumped over the lazy dog
				// 
				// Second iteration starts at quick, so goes 1, 2, .. 8, 0
				// Third starts at brown and goes 2, 3, .. 8, 0, 1
				// etc.
				if (index >= tokens.length)
					index = 0;
				
				// Concatenate current shifted line with the next token
				temp = temp + tokens[index] + " ";
				// Increment the index to use the next token
				index++;
			}
			
			// Add the completed shifted line to the list
			kwicList.add(temp);
		}
	}
	
	/**
	 * Displays the list on the screen
	 * 
	 * @param kwicList The list to display
	 */
	static void displayList(ArrayList<String> kwicList)
	{
		// Print the header
		System.out.println("\nList:");
		
		// Display each line in the list in turn
		for (int i = 0; i < kwicList.size(); i++)
			System.out.println(kwicList.get(i));
	}
}
