import java.util.*;

public abstract class MyController implements Observer
{
	// The Model this Controller is connected to
		protected MyModel model;
		
		// The View that this Controller controls
		protected MyView view;
		
		// Initialises the Controller by connecting it to the Model and View
		protected void initialize(MyModel model, MyView view)
		{
			this.model = model;
			this.view = view;
			// Add the Controller as an Observer of the Model
			this.model.addObserver(this);
			// Update the Controller to get the details from the Model
			this.update(null, null);
		}
}