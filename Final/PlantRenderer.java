/** uses a StringBuffer and a Turtle and renders a Turtle-drawn Lsystem.
 *  this class should probably NOT be overridden 
 * 
 * 
 * 
 * */
public class PlantRenderer extends Ri {
 


	
	

	private StringBuffer structure;
	private Turtle turtle;

	public PlantRenderer() {

}	

	public PlantRenderer(String structure, Turtle turtle, double width,
			double shrinkWidth, double length, double shrinkLength,
			double angleX, double angleY, double angleZ) {
	
		this.structure = new StringBuffer(structure);
		this.turtle = turtle;
	/*	this.width = width;
		this.shrinkWidth = shrinkWidth;
		this.length = length;
		this.shrinkLength = shrinkLength;
		this.angleX = angleX;
		this.angleY = angleY;
		this.angleZ = angleZ;
	*/
		}

	public PlantRenderer(String structure, Turtle turtle) {
	
		this.structure = new StringBuffer(structure);
		this.turtle = turtle;
	}


	public static void main(String[] args) {

		//new PlantRenderer().dothis();

	}
	

	public  void dothis() {
		
		//example2();
		
		}	
	
	 public void startPlantDrawing() {
		 this.startPlantDrawing(structure, turtle);
	 }
	
/** start the drawing of a plant
 * 
 * @param sample the StringBuffer that contains the output of the Lsystem derivation
 * @param t contains the Turtle which is used for drawing instructions
 */
	public void startPlantDrawing(StringBuffer sample, Turtle t) {
		Point start = new Point();
		start.width = t.getWidth();
		start.length = t.getLength();
		start.originalLength = start.length;
		start.originalWidth = start.width;

		RiTransformBegin();
		RiRotate(-90,1,0,0);
		RiAttributeBegin();
		new DoColor().color(t.getColor()[0],
				    t.getColor()[1],
				    t.getColor()[2]);
	
		plantDrawing(sample,t,start);

		RiAttributeEnd();
		RiTransformEnd();
	}



	protected void plantDrawing(StringBuffer spec,Turtle t,Point where) {

		boolean done = false;
		while (spec.length()!=0) {

			char firstStep = spec.charAt(0);
			spec.delete(0, 1);
			switch (firstStep) {
		case '[' : 
			RiTransformBegin();
			plantDrawing(spec,t,where.copy());
			break;
		case ']':
			t.outputLeaf(where);
			RiTransformEnd();
			done = true;
			break;
		default:	
		t.doOneStep(spec, where, firstStep);
		break;
			}
			if (done)
				return;
		}
	}
}
