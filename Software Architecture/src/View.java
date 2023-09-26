import java.util.*;

/**
 * The abstract class representing a View.  Note that this class implements Observer
 */
public abstract class View implements Observer
{
	// The Model this View is connected to
	protected Model model;
	
	// Connects the View to the Model
	public void initialize(Model model)
	{
		this.model = model;
		// Set the View as an Observer for the Model
		this.model.addObserver(this);
		// Call update.  This ensures that we get the details from the Model when
		// first initialised
		this.update(null, null);
	}
}
