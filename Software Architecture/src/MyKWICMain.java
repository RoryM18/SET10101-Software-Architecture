import java.util.*;

public class MyKWICMain 
{
	/**
	 * The main KWIC program
	 * 
	 * @param args Any arguments passed in from the command line
	 */
	public static void main(String[] args)
	{
		// First we create a user input variable to allow users to enter any string they want
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a sentnece");
		
		String line = input.nextLine();
		
		input.close();
		
		ArrayList<String> kwicList = new ArrayList<String>();

		shiftLine(line, kwicList);
		
		// All lines have been read in from the file.  Now sort the list.
		// We cheat and use Java's built in sort algorithm
		Collections.sort(kwicList);
		
		// Display the final, sorted list
		displayList(kwicList);
	}

	
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