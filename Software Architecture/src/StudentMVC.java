public class StudentMVC 
{
	public static void main(String[] args)
	{
		// Create a new Student model
		StudentModel model = new StudentModel("John Smith", "12345678", "BEng Software Engineering");
		// Create a new Student view
		StudentView view = new StudentView();
		// Create a new Student controller
		StudentController controller = new StudentController();
		// Attach the view to the model
		view.initialize(model);
		// Attach the controller to the model and the view
		controller.initialize(model, view);
	}
}
