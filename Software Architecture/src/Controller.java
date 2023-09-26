import java.util.*;

/**
 * Abstract class representing the Controller.  Note that this class implements Observer
 */
public abstract class Controller implements Observer
{
	// The Model this Controller is connected to
	protected Model model;
	
	// The View that this Controller controls
	protected View view;
	
	// Initialises the Controller by connecting it to the Model and View
	protected void initialize(Model model, View view)
	{
		this.model = model;
		this.view = view;
		// Add the Controller as an Observer of the Model
		this.model.addObserver(this);
		// Update the Controller to get the details from the Model
		this.update(null, null);
	}
}
