import java.io.*;

public class MyKWICPipeFilter {
	
	public static void main(String[] args)
	{
		try
		{
			// We need two pipes, A and B
			PipedReader pipeOutA = new PipedReader();
			PipedWriter pipeInA = new PipedWriter(pipeOutA);
			PipedReader pipeOutB = new PipedReader();
			PipedWriter pipeInB = new PipedWriter(pipeOutB);
			
			// Create the three filters
			KWICReadLineThread read = new KWICReadLineThread(pipeInA);
			KWICShiftLineThread shift = new KWICShiftLineThread(pipeOutA, pipeInB);
			KWICSortLineThread sort = new KWICSortLineThread(pipeOutB);
			
			
			// Start the four filters
			read.start();
			shift.start();
			sort.start();
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			System.exit(-1);
		}
	}

}
