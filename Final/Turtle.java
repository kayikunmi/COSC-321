import java.util.Vector;

/** implements a Turtle model of a plant drawer
 * 
 * the step can be any letter, the following have special meanings in the default Turtle:<p>
 * case 'E': case'F' :  move forward<p>
 * case '[': start a branch  (push state)<p>
 * case ']': end a branch (pop state)<p>
 * case '-'  '+': y rotation<p>
 * case 't'  's': z rotation<p>
 * case '\'  '/': x rotation<p>
 * case 'M', 'L', 'N':  call outputRealLeaf<p>
 * fields<p>
 * width the initial width<p>
 * shrinkWidth the multiplicative amount that the width shrinks (on a forward)<p>
 * length the initial length<p>
 * shrinkLength the multiplicative amount that the length shrinks (on a forward)<p>
 * angleX the angle of change for rotation around the X axis<p>
 * angleY the angle of change for rotation around the Y axis<p>
 * angleZ the angle of change for rotation around Z<p>
 */
 
 
public class Turtle extends Ri {

	
	
	protected double scaleLeaves;	
	protected Vector<Character> leaves;
	protected double[][] leafColors;

	
	protected double width = 50;
	protected double shrinkWidth = 1;
	protected double length = 50;
	protected double shrinkLength = 1;
	protected double angleX = 30;
	protected double angleY = 30;
	protected double angleZ = 30;
	protected double[] mainColor = {0.55, 0.4, 0.2};
	
	public Turtle() {
		this(3.0);
	}

	public Turtle(double sc) {
		scaleLeaves = sc;
		setLeaves(new char[] {'L','M','N'});


		setLeafColors(
				new double[][] 
				             {{0.0, 0.392, 0.0},
						{1.0, 0.0, 0.0},
						{0.62,0.12,0.9}
				             });

	}

	public Turtle(double width2, double shrinkWidth2, double length2,
			double shrinkLength2, double angleX2, double angleY2, double angleZ2, double[] c) {
		this(3.0);
		width = width2;
		length = length2;
		shrinkWidth = shrinkWidth2;
		shrinkLength = shrinkLength2;
		angleX = angleX2;
		angleY = angleY2;
		angleZ = angleZ2;
		mainColor = c;
	}
/** provide a list of characters which should be drawn as leaves */
	
	public void setLeaves(char[] ls) {
		leaves = new Vector<Character>();
		for (char c : ls)
			leaves.add(c);
	}

	/** set the colors of the leaves */
	
	public void setLeafColors(double[][] cols)  {
		leafColors = cols;
	}

	/** override or extend this to change the Turtle model.  extend by handling any char you want to
	 * handle and then call super.doOneStep to handle defaults
	 */
	
	public boolean doOneStep(StringBuffer spec, Point where, char firstStep) {

		if (leaves.indexOf(firstStep) != -1)
		{
			outputRealLeaf(where,firstStep);
			return false;
		}

		switch (firstStep) {
		case 'E': case'F' : 
			forward(where);
			break;

		case '-' :
			RiRotate(-angleY,0.0, 1.0, 0.0);
			break;
		case '+':
			RiRotate(+angleY,0.0, 1.0, 0.0);
			break;
		case 't':
			RiRotate(+angleZ,0.0,0.0,1.0);
			break;
		case 's':
			RiRotate(-angleZ, 0.0, 0.0, 1.0);
			break;
		case '\\':
			RiRotate(+angleZ,1.0, 0.0, 0.0);
			break;
		case '/':
			RiRotate(-angleZ,1.0, 0.0, 0.0);
			break;
		default:break;
		}
		return false;
	}

	/** move forward , drawing figure and shrinking width and length
	 * 
	 * @param where position 
	 *
	 */
	public void forward(Point where) {
		new DoColor().color(1.0,0.0,0.0);

		double halfWidth = where.width/2.0;

		double[] one = {halfWidth,0.0,0.0};
		double[] two = {halfWidth*0.9,0.0};
		RiHyperboloid(one,two,where.length,360.0);


		RiAttributeBegin();
		
		double[] origin = {0.0, 0.0, 0.0};
		RiPoints(1,"P",origin,"width",where.width,RI_NULL);
		RiAttributeEnd();




		RiTranslate(0.0, 0.0, where.length);


		RiAttributeBegin();
		RiPoints(1,"P",origin,"width",where.width,RI_NULL);
		RiAttributeEnd();


		if (where.width > 0.1) where.width = where.width*shrinkWidth;
		if (where.length > 0.1) where.length = where.length*shrinkLength;


	}


	/** output a leaf as a hexagon/polygon, override to change
	 * 
	 * @param where the current point
	 */
	public void outputRealLeaf(Point where, 
			char c) {

		double length = this.scaleLeaves*where.originalLength;
		double width = this.scaleLeaves*where.originalWidth;

		RiAttributeBegin();

		int which = leaves.indexOf(c);

		new DoColor().color(leafColors[which][0],leafColors[which][1],leafColors[which][2]);

		double[][] points = {
				{0.0, 0.0, 0.0},
				{width/2.0, 0.0, length/4.0},
				{width/2.0,0.0,length*3.0/4.0},
				{0.0, 0.0, length},	
				{-width/2.0,0.0,length*3.0/4.0},
				{-width/2.0, 0.0, length/4.0}};
		RiPolygon(6,RI_P,points,RI_NULL);
		double[] origin = {0.0, 0.0, 0.0};
		RiPoints(1,"P",origin,"width",where.width,RI_NULL);
		RiAttributeEnd();

	}

	public double getScaleLeaves() {
		return scaleLeaves;
	}


	protected void setScaleLeaves(double d) {

		scaleLeaves = d;
	}

	/** output a point as a leaf
	 * 
	 * @param where  place
	 */

	public void outputLeaf(Point where) {
		RiAttributeBegin();
		new DoColor().color(0.0, 1.0, 0.0);
		double[] origin = {0.0, 0.0, 0.0};
		RiPoints(1,"P",origin,"width",(0.9*where.width/shrinkWidth),RI_NULL);
		RiAttributeEnd();

	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double[] getColor() {
		return mainColor;
	}
}

