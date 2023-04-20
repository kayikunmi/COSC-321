
public class SpecialTurtle extends Turtle {


	public SpecialTurtle(double width, double shrinkWidth, double length, 
			double shrinkLength, double aX, double aY, double aZ, double[] c) {
		super( width,  shrinkWidth,  length,  shrinkLength,  aX,  aY,  aZ, c);
	}

	public void outputRealLeaf(Point where, char c) {

		super.outputRealLeaf(where,c);
	}

	public boolean doOneStep(StringBuffer spec, Point where, char firstStep) {
		switch (firstStep) {

		case 'R':
			outputRealLeaf(where,firstStep);break;
		default:super.doOneStep(spec,where,firstStep);
		}
		return false;
	}
}
