import java.util.*;

public abstract class PlaneView implements Observer
{
	// The Model this View is connected to
		protected PlaneModel model;
		
		// Connects the View to the Model
		public void initialize(PlaneModel model)
		{
			this.model = model;
			// Set the View as an Observer for the Model
			this.model.addObserver(this);
			// Call update.  This ensures that we get the details from the Model when
			// first initialised
			this.update(null, null);
		}
}
