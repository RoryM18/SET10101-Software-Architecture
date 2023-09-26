import java.io.*;
import java.util.*;

public class KWICObject 
{
	/**
	 * The reader used to read lines from the file
	 */
	BufferedReader input_file;
	
	/**
	 * The list of shifted lines
	 */
	private ArrayList<String> kwicList = new ArrayList<String>();
	
	/**
	 * Constructor to create a new KWICObject
	 * 
	 * @param file_name The name of the file to read lines from
	 * 
	 * @throws IOException Thrown if there is a problem during I/O
	 */
	public KWICObject(String file_name) throws IOException
	{
		// Open the file
		openFile(file_name);
		
		// Loop until the file is empty
		while (input_file.ready())
		{
			// Read a line
			String line = readLine();
			// Shift the line
			shiftLine(line);
		}
		
		// Sort the list
		Collections.sort(this.kwicList);
	}
	
	/**
	 * Opens the file
	 * 
	 * @param file_name The name of the file to open
	 * @throws IOException Thrown if something goes wrong during the I/O operations
	 */
	private void openFile(String file_name) throws IOException
	{
		// Open the file with the given file name
		FileReader file = new FileReader(file_name);
		// Create the BufferedReader for the file
		this.input_file = new BufferedReader(file);
	}
	
	/**
	 * Reads the next line from the file
	 * 
	 * @return The string read from the file
	 * @throws IOException Thrown if something goes wrong during the I/O operations
	 */
	private String readLine() throws IOException
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
	 */
	private void shiftLine(String line)
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
			this.kwicList.add(temp);
		}
	}
	
	/**
	 * Displays the list on the screen
	 * 
	 * @param kwicList The list to display
	 */
	public void displayList()
	{
		// Print the header
		System.out.println("\nList:");
		
		// Display each line in the list in turn
		for (int i = 0; i < this.kwicList.size(); i++)
			System.out.println(this.kwicList.get(i));
	}
	
	/**
	 * Gets the list of shifted lines
	 * 
	 * @return The ArrayList holding the shifted lines
	 */
	public ArrayList<String> getKWICList()
	{
		return this.kwicList;
	}
}
