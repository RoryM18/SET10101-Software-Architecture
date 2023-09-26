import java.util.*;

import javax.swing.*;
import java.awt.*;

public class StudentView extends View
{
	// Label containing the Name
	private JLabel name;
	
	// Label containing the Matric Number
	private JLabel matric;
	
	// Label containing the Programme
	private JLabel programme;
	
	// Window used to display the details
	private JFrame window;
	
	public StudentView()
	{
		// Create the GUI components
		window = new JFrame();
		name = new JLabel();
		matric = new JLabel();
		programme = new JLabel();
		
		// Set the GUI layout
		window.setLayout(new GridLayout(3, 1));
		
		// Add the labels to the window
		window.add(name);
		window.add(matric);
		window.add(programme);
		
		// Set the window title
		window.setTitle("View");
		
		// Resize the window to fit the components
		window.pack();
		
		// Display the window
		window.setVisible(true);
	}

	/**
	 * Updates View. Called by the Model when it notifies the Observers
	 */
	public void update(Observable o, Object arg) 
	{
		// Change the label contents the new Model values
		this.name.setText(((StudentModel)model).getName());
		this.matric.setText(((StudentModel)model).getMatricNumber());
		this.programme.setText(((StudentModel)model).getProgramme());
		// Resize the window to fit the values
		window.pack();
	}

}
