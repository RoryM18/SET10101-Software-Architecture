public class StudentModel extends Model
{
	// Student name
	private String name;
	
	// Student matriculation number
	private String matricNumber;
	
	// Student programme
	private String programme;
	
	/**
	 * Creates a new Student Model
	 * 
	 * @param name Name of the Student
	 * @param matricNumber Matriculation Number of the Student
	 * @param programme Programme of the Student
	 */
	public StudentModel(String name, String matricNumber, String programme)
	{
		this.name = name;
		this.matricNumber = matricNumber;
		this.programme = programme;
	}
	
	/**
	 * Sets (changes) the Student name
	 * 
	 * @param name The new name of the Student
	 */
	public void setName(String name)
	{
		this.name = name;
		// For the Observers we need to set that the Model has changed
		this.setChanged();
		// Now notify the Observers (View and Controller)
		this.notifyObservers();
	}
	
	/**
	 * Gets the Student name
	 * 
	 * @return The name of the Student
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets (changes) the Student matric number
	 * 
	 * @param matricNumber The new Student matric number
	 */
	public void setMatricNumber(String matricNumber)
	{
		this.matricNumber = matricNumber;
		// For the Observers we need to set that the Model has changed
		this.setChanged();
		// Now notify the Observers (View and Controller)
		this.notifyObservers();
	}
	
	/**
	 * Gets the Student matric number
	 * 
	 * @return The matric number of the Student
	 */
	public String getMatricNumber()
	{
		return matricNumber;
	}
	
	/**
	 * Sets (changes) the Student programme
	 * 
	 * @param programme The new Student programme 
	 */
	public void setProgramme(String programme)
	{
		this.programme = programme;
		// For the Observers we need to set that the Model has changed
		this.setChanged();
		// Now notify the Observers (View and Controller)
		this.notifyObservers();
	}
	
	/**
	 * Gets the Student programme
	 * 
	 * @return The programme of the Student
	 */
	public String getProgramme()
	{
		return programme;
	}
	
}
