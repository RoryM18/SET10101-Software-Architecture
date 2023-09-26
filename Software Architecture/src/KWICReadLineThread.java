import java.io.*;

public class KWICReadLineThread extends Thread
{
	private PipedWriter pipeIn;
	private BufferedReader input_file;
	
	KWICReadLineThread(PipedWriter pipeIn)
	{
		this.pipeIn = pipeIn;
	}
	
	public void run()
	{
		try
		{
			//Open the file
			FileReader file = new FileReader("C:\\Users\\rorym\\OneDrive - Edinburgh Napier University\\Uni\\Year 4\\Trimester 1\\Software Architecture\\Practicals\\Software Architecture\\src\\kwic.dat");
			input_file = new BufferedReader(file);
			
			//Loop until EOF
			while(input_file.ready())
			{
				//Read next line from the file
				String line = input_file.readLine();
				//Write line to the pipe
				pipeIn.write(line + "\n");
				//Push the data through
				pipeIn.flush();
			}
		}
		catch(FileNotFoundException fnf)
		{
			System.err.println("Could not open file");
			System.err.println(fnf.getMessage());
			System.exit(-1);
		}
		catch (IOException ioe)
		{
			System.err.println("Error during I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}
}
