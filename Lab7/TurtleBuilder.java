
/** use to create a Turtle  usage:
 * 
 * Turtle t = new TurtleBuilder().width(10).shrinkLength(0.5).build();
 * will use the default for all fields not set  the last call must be build()
 * 
 */

public class TurtleBuilder {

	
	
	private double width = 50;
	private double shrinkWidth = 1;
	private double length = 50;
	private double shrinkLength = 1;
	private double angleX = 30;
	private double angleY = 30;
	private double angleZ = 30;
	private double[] mainColor = {0.55, 0.4, 0.2};

	public Turtle build() {
		Turtle pr = new Turtle(width, shrinkWidth, length, shrinkLength, angleX, angleY,angleZ,mainColor);
		return pr;
	}
	

	public Turtle buildSpecial() {
		Turtle pr = new SpecialTurtle(width, shrinkWidth, length, shrinkLength, angleX, angleY,angleZ,mainColor);
		return pr;
	}
	
	public TurtleBuilder mainColor(double[] d) {
		mainColor = d;
		return this;
	}
	
	public TurtleBuilder width(double w) {
		width = w;
		return this;
	}
	
	public TurtleBuilder shrinkWidth(double w) {
		shrinkWidth = w;
		return this;
	}
	
	public TurtleBuilder length(double w) {
		length = w;
		return this;
	}
	
	public TurtleBuilder shrinkLength(double w) {
		shrinkLength = w;
		return this;
	}
	
	public TurtleBuilder angleX(double a) {
		angleX  = a;
		return this;
	}
	
	public TurtleBuilder angleY(double a) {
		angleY  = a;
		return this;
	}
	
	public TurtleBuilder angleZ(double a) {
		angleZ  = a;
		return this;
	}
	
}
