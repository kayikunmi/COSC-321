
public class SpecialTurtle extends KTurtle {


	public SpecialTurtle(double width, double shrinkWidth, double length, 
			double shrinkLength, double aX, double aY, double aZ, double[] c) {
		super( width,  shrinkWidth,  length,  shrinkLength,  aX,  aY,  aZ, c);
	}

	public void outputRealLeaf(Point where, char c) {

		super.outputRealLeaf(where,c);
	}

	public boolean doOneStep(StringBuffer spec, Point where, char firstStep) {
		switch (firstStep) {

		// case'F' : 
		// 	forward(where);
		// 	break;
		case 'R':
			outputRealLeaf(where,firstStep);
			RiRotate(+angleY, 0.0, 1.0, 1.0);
			break;
		case '+':
			RiRotate(+angleZ,0.75, 1.0, 0.2);
			break;
		case '-':
			RiRotate(+angleZ,0.2, 0.75, 1.0);
			break;
		case '[':
			RiRotate(+angleX, 0.8, 1.0, 0.5);
			break;
		case ']':
			RiRotate(+angleY, 1.0, 0.8, 0.5);
			break;

		default:super.doOneStep(spec,where,firstStep);
		}
		return false;
	}
}
