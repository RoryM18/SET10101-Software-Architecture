import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentController extends Controller
{
	// The text box containing the Name
	private JTextField name = new JTextField(20);
	
	// The text box containing the matric number
	private JTextField matric = new JTextField(8);
	
	// The text box containing the programme
	private JTextField programme = new JTextField(20);
	
	public StudentController()
	{
		// Set up GUI components
		JFrame window = new JFrame();
		JLabel nameLabel = new JLabel("Name");
		JLabel matricLabel = new JLabel("Matric. No.");
		JLabel programmeLabel = new JLabel("Programme");
		
		// Add event listeners to the text boxes
		name.addKeyListener(new NameTextBoxListener());
		matric.addKeyListener(new MatricTextBoxListener());
		programme.addKeyListener(new ProgrammeTextBoxListener());
		
		// Set the GUI layout
		window.setLayout(new FlowLayout());
		
		// Add the components to the window
		window.add(nameLabel);
		window.add(name);
		window.add(matricLabel);
		window.add(matric);
		window.add(programmeLabel);
		window.add(programme);
		
		// Set the window title
		window.setTitle("Controller");
		
		// Resize the window to fit the components
		window.pack();
		
		// Set window close action to exit the application
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Display the window
		window.setVisible(true);
	}
	
	/**
	 * Updates the Controller.  This is called by the Model when it is changed
	 */
	public void update(Observable o, Object arg) 
	{
		// Update the text boxes
		name.setText(((StudentModel)model).getName());
		matric.setText(((StudentModel)model).getMatricNumber());
		programme.setText(((StudentModel)model).getProgramme());
	}

	// This is the listener for the Name text box.  Any time a key event occurs
	// then the name in the model is updated
	class NameTextBoxListener implements KeyListener
	{
		public void keyPressed(KeyEvent event) 
		{
			((StudentModel)model).setName(name.getText());
		}

		public void keyReleased(KeyEvent event) 
		{
			((StudentModel)model).setName(name.getText());
		}

		public void keyTyped(KeyEvent event) 
		{
			((StudentModel)model).setName(name.getText());
		}
	}
	
	// This is the listener for the matric text box.  Any time a key event occurs
	// then the matric number in the model is updated
	class MatricTextBoxListener implements KeyListener
	{
		public void keyPressed(KeyEvent event) 
		{
			((StudentModel)model).setMatricNumber(matric.getText());
		}

		public void keyReleased(KeyEvent event) 
		{
			((StudentModel)model).setMatricNumber(matric.getText());
		}

		public void keyTyped(KeyEvent event) 
		{
			((StudentModel)model).setMatricNumber(matric.getText());
		}
	}
	
	// This is the listener for the programme text box.  Any time a key event occurs
	// then the programme in the model is updated
	class ProgrammeTextBoxListener implements KeyListener
	{
		public void keyPressed(KeyEvent event) 
		{
			((StudentModel)model).setProgramme(programme.getText());
		}

		public void keyReleased(KeyEvent event) 
		{
			((StudentModel)model).setProgramme(programme.getText());
		}

		public void keyTyped(KeyEvent event) 
		{
			((StudentModel)model).setProgramme(programme.getText());
		}
	}
	
}
