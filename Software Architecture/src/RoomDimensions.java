import java.util.Scanner;


public class RoomDimensions {
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a Length");
		
		float length = input.nextFloat();
		
		System.out.println("Please enter a Breadth");
		
		float breadth = input.nextFloat();
		
		System.out.println("Please enter a Height");
		
		float height = input.nextFloat();
		
		float area, perimeter, volume;
		
		area = length * breadth;
		perimeter = 2 * length + 2 * breadth;
		volume = length * breadth * height;
		
		System.out.println("length(m) : " + length);
		System.out.println("breadth(m) : " + breadth);
		System.out.println("hieght(m) : " + height);
		System.out.println("area = " + area + " sq m");
		System.out.println("perimeter(m) = " + perimeter);
		System.out.println("volume(m) = " + volume);
	}

}
